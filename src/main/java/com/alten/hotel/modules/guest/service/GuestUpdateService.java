package com.alten.hotel.modules.guest.service;

import com.alten.hotel.modules.guest.model.Guest;
import com.alten.hotel.modules.guest.repository.GuestRepository;
import com.alten.hotel.modules.guest.resource.GuestParameterRequest;
import com.alten.hotel.modules.guest.serializer.GuestSerializer;
import com.alten.hotel.modules.guest.type.GuestOperationType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.UUID;

@ApplicationScoped
public class GuestUpdateService implements GuestService
{
    @Inject GuestRepository repo;

    @Inject GuestSerializer serializer;

    private void updateEntity(UUID uuid, Guest request, Guest guest)
    {
        this.serializer.update(request, guest);
        guest.setUuid(uuid);
        guest.setUpdatedAT(this.getFormattedDate());
    }

    @Transactional
    public Guest update(String uuidRequest, Guest request)
    {
        var uuid = this.toUUID(uuidRequest);
        var guest = this.repo.findByID(uuid);
        this.updateEntity(uuid, request, guest);
        return this.execute(
                this.repo,
                new GuestParameterRequest(
                        GuestOperationType.CREATE_UPDATE_GUEST,
                        null,
                        guest
                )
        );
    }
}
