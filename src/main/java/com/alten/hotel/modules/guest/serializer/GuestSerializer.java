package com.alten.hotel.modules.guest.serializer;

import com.alten.hotel.modules.guest.model.Guest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import javax.inject.Inject;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GuestSerializer
{
    void update(Guest request, @MappingTarget Guest guest);
}
