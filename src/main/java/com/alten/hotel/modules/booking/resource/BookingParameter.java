package com.alten.hotel.modules.booking.resource;

import com.alten.hotel.modules.booking.type.AccommodationType;
import com.alten.hotel.modules.booking.type.BookingStatusType;

import java.time.LocalDateTime;

public record BookingParameter(BookingStatusType status,
                               AccommodationType accommodation,
                               LocalDateTime entryAT,
                               LocalDateTime exitAT) { }
