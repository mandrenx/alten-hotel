package com.alten.hotel.modules.booking.exception.errors;

public enum BookingErrorMessage
{
    BKGMSG0001(BookingErrorCode.BKGCOD0001, "Trying to save a new booking failed or trying to update booking data failed!"),
    BKGMSG0002(BookingErrorCode.BKGCOD0002, "Trying to validate allowed booking data OR trying to validate known types failed!"),
    BKGMSG0003(BookingErrorCode.BKGCOD0003, "Trying to list bookings by accommodation type failed!"),
    BKGMSG0004(BookingErrorCode.BKGCOD0004, "Trying to list bookings by period failed!"),
    BKGMSG0005(BookingErrorCode.BKGCOD0005, "Trying to list bookings by status failed!"),
    BKGMSG0006(BookingErrorCode.BKGCOD0006, "Booking period must be less than 30 days!"),
    BKGMSG0007(BookingErrorCode.BKGCOD0007, "Maximum period of stay is 3 days!");

    private final BookingErrorCode code;

    private final String message;

    BookingErrorMessage(BookingErrorCode code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public String getMessage() { return this.code + " | " + this.message; }
}
