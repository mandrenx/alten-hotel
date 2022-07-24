package com.alten.hotel.modules.bedroom.service;

import com.alten.hotel.commons.service.BaseService;
import com.alten.hotel.modules.bedroom.model.Bedroom;
import com.alten.hotel.modules.bedroom.type.BedroomStatusType;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class BedroomUpdateService implements BaseService<Bedroom>
{
    public Bedroom update(UUID uuid, String status)
    {
        var bedroom = this.searchByID("idrm", uuid);
        bedroom.setStatus(BedroomStatusType.valueOf(status));
        return this.insertUpdate(bedroom);
    }
}
