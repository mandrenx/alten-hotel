package com.alten.hotel.modules.guest.exception.errors;

public enum GuestErrorMessage
{
    GSTMSG0001(GuestErrorCode.GSTCOD0001, "Trying to save a new guest failed or trying to update guest data failed!"),
    GSTMSG0002(GuestErrorCode.GSTCOD0002, "Trying to validate allowed data OR trying to validate known types failed!"),
    GSTMSG0003(GuestErrorCode.GSTCOD0003, "There's no result for this name!"),
    GSTMSG0004(GuestErrorCode.GSTCOD0004, "There's no result for this email!"),
    GSTMSG0005(GuestErrorCode.GSTCOD0005, "There's no result for this phone number!");

    private final GuestErrorCode code;

    private final String message;

    GuestErrorMessage(GuestErrorCode code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public String getMessage() { return this.code + " | " + this.message; }
}
