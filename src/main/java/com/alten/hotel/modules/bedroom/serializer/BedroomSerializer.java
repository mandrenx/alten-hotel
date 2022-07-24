package com.alten.hotel.modules.bedroom.serializer;

import com.alten.hotel.commons.serializer.BaseSerializer;
import com.alten.hotel.modules.bedroom.model.Bedroom;
import com.alten.hotel.modules.bedroom.resource.BedroomRequest;
import com.alten.hotel.modules.bedroom.resource.BedroomResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "cdi", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BedroomSerializer extends BaseSerializer<Bedroom, BedroomRequest, BedroomResponse> { }
