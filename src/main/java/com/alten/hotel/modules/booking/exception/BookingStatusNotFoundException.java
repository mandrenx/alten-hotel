package com.alten.hotel.modules.booking.exception;

import com.alten.hotel.modules.booking.exception.errors.BookingErrorMessage;

public class BookingStatusNotFoundException extends RuntimeException
{
    public BookingStatusNotFoundException(BookingErrorMessage message) { super(message.getMessage()); }
}
