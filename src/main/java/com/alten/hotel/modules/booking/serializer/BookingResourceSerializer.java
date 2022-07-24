package com.alten.hotel.modules.booking.serializer;

import com.alten.hotel.commons.serializer.BaseSerializer;
import com.alten.hotel.modules.booking.model.Booking;
import com.alten.hotel.modules.booking.resource.BookingRequest;
import com.alten.hotel.modules.booking.resource.BookingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookingResourceSerializer extends BaseSerializer<Booking, BookingRequest, BookingResponse> { }
