package com.alten.hotel.modules.guest.exception.errors;

import com.alten.hotel.modules.booking.exception.errors.BookingErrorMessage;

public enum BookingError
{
    BKG0001(BookingErrorMessage.BKGMSG0001),
    BKG0002(BookingErrorMessage.BKGMSG0002),
    BKG0003(BookingErrorMessage.BKGMSG0003),
    BKG0004(BookingErrorMessage.BKGMSG0004),
    BKG0005(BookingErrorMessage.BKGMSG0005),
    BKG0006(BookingErrorMessage.BKGMSG0006),
    BKG0007(BookingErrorMessage.BKGMSG0007);

    private final BookingErrorMessage message;

    BookingError(BookingErrorMessage message) { this.message = message; }

    public String getDescription() { return this.message.getMessage(); }
}
