package com.alten.hotel.modules.guest.service;

import com.alten.hotel.modules.guest.exception.errors.GuestError;
import com.alten.hotel.modules.guest.model.Guest;
import com.alten.hotel.modules.guest.repository.GuestRepository;
import com.alten.hotel.modules.guest.resource.GuestParameterRequest;
import com.alten.hotel.modules.guest.type.EntryRegisterType;
import com.alten.hotel.modules.guest.type.GuestOperationType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Objects;
import java.util.stream.Stream;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@ApplicationScoped
public class GuestCreateService implements GuestService
{
    @Inject GuestRepository repo;

    private Boolean verifyData(Guest guest)
    {
        var isNullValue = Stream.of(guest.getFirstname(), guest.getLastname(), guest.getEmail(),
                        guest.getPhoneNumber(), guest.getRegisterType(), guest.getRegisteredAT())
                .allMatch(Objects::isNull);

        var isInvalidEntry = guest.getRegisterType() != EntryRegisterType.SINGLE
                && guest.getPeopleQnty() == 0 ? TRUE : FALSE;

        return isInvalidEntry && isNullValue;
    }

    @Transactional
    public Guest create(Guest request)
    {
        if (this.verifyData(request)) this.throwGuestException(GuestError.GST0002);
        return this.execute(this.repo,
                new GuestParameterRequest(
                        GuestOperationType.CREATE_UPDATE_GUEST,
                        null,
                        request
                )
        );
    }
}
