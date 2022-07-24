package com.alten.hotel.modules.booking.exception;

import com.alten.hotel.modules.booking.exception.errors.BookingErrorMessage;

public class BookingAccommodationNotFoundException extends RuntimeException
{
    public BookingAccommodationNotFoundException(BookingErrorMessage message) { super(message.getMessage()); }
}
