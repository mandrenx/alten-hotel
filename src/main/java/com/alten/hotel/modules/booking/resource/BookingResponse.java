package com.alten.hotel.modules.booking.resource;

import com.alten.hotel.modules.booking.type.AccommodationType;
import com.alten.hotel.modules.booking.type.BookingStatusType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;
import java.util.UUID;

public record BookingResponse(UUID uuid,
                              String room,
                              BookingStatusType status,
                              AccommodationType accommodation,

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
                              LocalDateTime updatedAT) {

    public static BookingResponse build() {
        return new BookingResponse(null, null, null, null, null, null, null, null);
    }
}
