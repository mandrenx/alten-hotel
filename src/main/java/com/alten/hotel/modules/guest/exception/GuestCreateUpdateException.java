package com.alten.hotel.modules.guest.exception;

import com.alten.hotel.modules.guest.exception.errors.GuestErrorMessage;

public class GuestCreateUpdateException extends RuntimeException
{
    public GuestCreateUpdateException(GuestErrorMessage message) { super(message.getMessage()); }
}
