package com.alten.hotel.modules.guest.resource;

import com.alten.hotel.modules.guest.type.EntryRegisterType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.time.LocalDateTime;
import java.util.UUID;

public record GuestResponse(UUID uuid,
                            String firstname,
                            String lastname,
                            String email,
                            String phoneNumber,
                            EntryRegisterType registerType,
                            Integer peopleQnty,

                            @JsonDeserialize(using = LocalDateDeserializer.class)
                            @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                            @JsonProperty("registeredAT")
                            LocalDateTime registeredAT,

                            @JsonDeserialize(using = LocalDateDeserializer.class)
                            @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                            @JsonProperty("updatedAT")
                            LocalDateTime updatedAT) { }
