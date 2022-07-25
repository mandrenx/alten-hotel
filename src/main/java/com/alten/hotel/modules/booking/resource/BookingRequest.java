package com.alten.hotel.modules.booking.resource;

import com.alten.hotel.modules.booking.type.AccommodationType;
import com.alten.hotel.modules.booking.type.BookingStatusType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.UUID;

public record BookingRequest(UUID uuid,
                             BookingStatusType status,
                             AccommodationType accommodation,

                             @JsonSerialize(using = LocalDateTimeSerializer.class)
                             @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                             @JsonProperty("entryAT")
                             LocalDateTime entryAT,

                             @JsonSerialize(using = LocalDateTimeSerializer.class)
                             @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                             @JsonProperty("exitAT")
                             LocalDateTime exitAT,

                             @JsonSerialize(using = LocalDateTimeSerializer.class)
                             @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                             @JsonProperty("registeredAT")
                             LocalDateTime registeredAT,

                             @JsonSerialize(using = LocalDateTimeSerializer.class)
                             @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                             @JsonProperty("updatedAT")
                             LocalDateTime updatedAT) { }
