package com.alten.hotel.modules.guest.internal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;
import java.util.UUID;

public record BookingGuestResponse(UUID uuid,
                                   String room,
                                   String status,
                                   String accommodation,

                                   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
                                   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                                   @JsonProperty("entryAT")
                                   LocalDateTime entryAT,

                                   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
                                   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                                   @JsonProperty("exitAT")
                                   LocalDateTime exitAT,

                                   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
                                   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                                   @JsonProperty("registeredAT")
                                   LocalDateTime registeredAT,

                                   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
                                   @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                                   @JsonProperty("updatedAT")
                                   LocalDateTime updatedAT) { }
