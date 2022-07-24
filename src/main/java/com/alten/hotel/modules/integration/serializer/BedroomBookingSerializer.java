package com.alten.hotel.modules.integration.serializer;

import com.alten.hotel.commons.serializer.BaseSerializer;
import com.alten.hotel.modules.integration.model.BedroomBooking;
import com.alten.hotel.modules.integration.resource.BedroomBookingRequest;
import com.alten.hotel.modules.integration.resource.BedroomBookingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BedroomBookingSerializer extends BaseSerializer<BedroomBooking, BedroomBookingRequest, BedroomBookingResponse> { }
