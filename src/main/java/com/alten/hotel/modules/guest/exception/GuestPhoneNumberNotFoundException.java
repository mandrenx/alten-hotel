package com.alten.hotel.modules.guest.exception;

import com.alten.hotel.modules.guest.exception.errors.GuestErrorMessage;

public class GuestPhoneNumberNotFoundException extends RuntimeException
{
    public GuestPhoneNumberNotFoundException(GuestErrorMessage message) { super(message.getMessage()); }
}
