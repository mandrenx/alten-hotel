package com.alten.hotel.modules.guest.exception;

import com.alten.hotel.modules.guest.exception.errors.GuestErrorMessage;

public class GuestEmailNotFoundException extends RuntimeException
{
    public GuestEmailNotFoundException(GuestErrorMessage message) { super(message.getMessage()); }
}
