package com.alten.hotel.modules.integration.resource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;
import java.util.UUID;

public record GuestIntegrationResponse(UUID guestID,

                                       @JsonDeserialize(using = LocalDateTimeDeserializer.class)
                                       @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                                       @JsonProperty("addedAT")
                                       LocalDateTime addedAT) { }
