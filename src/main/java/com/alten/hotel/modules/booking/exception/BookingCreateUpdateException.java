package com.alten.hotel.modules.booking.exception;

import com.alten.hotel.modules.booking.exception.errors.BookingErrorMessage;

public class BookingCreateUpdateException extends RuntimeException
{
    public BookingCreateUpdateException(BookingErrorMessage message) { super(message.getMessage()); }
}
