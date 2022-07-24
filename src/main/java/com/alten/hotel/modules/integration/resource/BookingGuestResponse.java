package com.alten.hotel.modules.integration.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.UUID;

public record BookingGuestResponse(UUID uuid,
                                   UUID bookingID,
                                   UUID guestID,

                                   @JsonSerialize(using = LocalDateTimeSerializer.class)
                                   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                                   @JsonProperty("addedAT")
                                   LocalDateTime addedAT) { }
