package com.alten.hotel.modules.booking.exception;

import com.alten.hotel.modules.booking.exception.errors.BookingErrorMessage;

public class BookingPeriodNotFoundException extends RuntimeException
{
    public BookingPeriodNotFoundException(BookingErrorMessage message) { super(message.getMessage()); }
}
