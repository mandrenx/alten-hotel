package com.alten.hotel.modules.booking.exception.errors;

import com.alten.hotel.modules.guest.exception.errors.BookingError;

public record BookingErrorResponse(BookingError error, String description) { }
