package com.alten.hotel.modules.booking.serializer;

import com.alten.hotel.modules.booking.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookingSerializer
{
    void update(Booking request, @MappingTarget Booking booking);
}
