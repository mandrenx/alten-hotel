package com.alten.hotel.modules.booking.internal.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.UUID;

public record BedroomIntegrationRequest(UUID uuid,
                                        UUID bedroomID,
                                        UUID bookingID,

                                        @JsonSerialize(using = LocalDateTimeSerializer.class)
                                        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                                        @JsonProperty("addedAT")
                                        LocalDateTime addedAT) { }
