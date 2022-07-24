package com.alten.hotel.modules.guest.exception.errors;

public enum GuestError
{
    GST0001(GuestErrorMessage.GSTMSG0001),
    GST0002(GuestErrorMessage.GSTMSG0002),
    GST0003(GuestErrorMessage.GSTMSG0003),
    GST0004(GuestErrorMessage.GSTMSG0004),
    GST0005(GuestErrorMessage.GSTMSG0005);

    private final GuestErrorMessage message;

    GuestError(GuestErrorMessage message) { this.message = message; }

    public String getDescription() { return this.message.getMessage(); }
}
