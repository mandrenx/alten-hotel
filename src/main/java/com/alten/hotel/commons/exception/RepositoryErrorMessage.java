package com.alten.hotel.commons.exception;

public enum RepositoryErrorMessage
{
    MSG0001(RepositoryErrorCode.COD0001, "Trying to find a entity by Object(s) failed!"),
    MSG0002(RepositoryErrorCode.COD0002, "Trying to find a entity by Parameter(s) failed!"),
    MSG0003(RepositoryErrorCode.COD0003, "Trying to find a entity by UUID failed!"),
    MSG0004(RepositoryErrorCode.COD0004, "Trying to list entities by Object(s) failed!"),
    MSG0005(RepositoryErrorCode.COD0005, "Trying to list entities by Parameter(s) failed!"),
    MSG0006(RepositoryErrorCode.COD0006, "Trying to delete entity failed!"),
    MSG0007(RepositoryErrorCode.COD0007, "Trying to save a new entity failed OR trying to update entity's data failed!"),
    MSG0008(RepositoryErrorCode.COD0008, "Trying to validate UUID format failed!!");

    private final String message;

    private final RepositoryErrorCode code;

    RepositoryErrorMessage(RepositoryErrorCode code, String message)
    {
        this.code = code;
        this.message = message;
    }

    public String getMessage() { return this.code + " | " + this.message; }
}