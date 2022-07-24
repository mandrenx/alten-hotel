package com.alten.hotel.modules.guest.exception;

import com.alten.hotel.modules.guest.exception.errors.GuestErrorMessage;

public class GuestFullNameNotFoundException extends RuntimeException
{
    public GuestFullNameNotFoundException(GuestErrorMessage message) { super(message.getMessage()); }
}
