package com.alten.hotel.modules.guest.exception;

import com.alten.hotel.modules.guest.exception.errors.GuestErrorMessage;

public class GuestOperationNotAllowedException extends RuntimeException
{
    public GuestOperationNotAllowedException(GuestErrorMessage message) { super(message.getMessage()); }
}
