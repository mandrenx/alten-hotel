package com.alten.hotel.modules.guest.service;

import com.alten.hotel.modules.guest.model.Guest;
import com.alten.hotel.modules.guest.repository.GuestRepository;
import com.alten.hotel.modules.guest.resource.GuestParameter;
import com.alten.hotel.modules.guest.resource.GuestParameterRequest;
import com.alten.hotel.modules.guest.type.GuestOperationType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class GuestSearchService implements GuestService
{
    @Inject GuestRepository repo;

    public Guest findByEmail(String email)
    {
        return this.execute(
                this.repo,
                new GuestParameterRequest(
                        GuestOperationType.FIND_GUEST_BY_EMAIL,
                        new GuestParameter(
                                Optional.empty(),
                                Optional.empty(),
                                Optional.of(email),
                                Optional.empty()
                        ),
                        null
                )
        );
    }

    public Guest findByFullName(String firstname, String lastname)
    {
        return this.execute(
                this.repo,
                new GuestParameterRequest(
                        GuestOperationType.FIND_GUEST_BY_FULL_NAME,
                        new GuestParameter(
                                Optional.of(firstname),
                                Optional.of(lastname),
                                Optional.empty(),
                                Optional.empty()
                        ),
                        null
                )
        );
    }

    public Guest findByPhoneNumber(String phoneNumber)
    {
        return this.execute(
                this.repo,
                new GuestParameterRequest(
                        GuestOperationType.FIND_GUEST_BY_PHONE_NUMBER,
                        new GuestParameter(
                                Optional.empty(),
                                Optional.empty(),
                                Optional.empty(),
                                Optional.of(phoneNumber)
                        ),
                        null
                )
        );
    }
}
