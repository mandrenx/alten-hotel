package com.alten.hotel.modules.booking.exception;

import com.alten.hotel.modules.booking.exception.errors.BookingErrorMessage;

public class BookingOperationNotAllowedException extends RuntimeException
{
    public BookingOperationNotAllowedException(BookingErrorMessage message) { super(message.getMessage()); }
}
