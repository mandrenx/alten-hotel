package com.alten.hotel.modules.integration.serializer;

import com.alten.hotel.commons.serializer.BaseSerializer;
import com.alten.hotel.modules.integration.model.BookingGuest;
import com.alten.hotel.modules.integration.resource.BookingGuestRequest;
import com.alten.hotel.modules.integration.resource.BookingGuestResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookingGuestSerializer extends BaseSerializer<BookingGuest, BookingGuestRequest, BookingGuestResponse> { }
