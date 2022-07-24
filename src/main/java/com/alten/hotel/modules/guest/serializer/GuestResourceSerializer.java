package com.alten.hotel.modules.guest.serializer;

import com.alten.hotel.commons.serializer.BaseSerializer;
import com.alten.hotel.modules.guest.model.Guest;
import com.alten.hotel.modules.guest.resource.GuestRequest;
import com.alten.hotel.modules.guest.resource.GuestResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GuestResourceSerializer extends BaseSerializer<Guest, GuestRequest, GuestResponse> { }
