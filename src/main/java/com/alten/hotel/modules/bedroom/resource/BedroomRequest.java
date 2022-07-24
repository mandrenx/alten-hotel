package com.alten.hotel.modules.bedroom.resource;

import com.alten.hotel.modules.bedroom.type.BedroomStatusType;

import java.util.UUID;

public record BedroomRequest(UUID uuid,
                             String floor,
                             String aptNumber,
                             BedroomStatusType status) { }
