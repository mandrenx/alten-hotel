package com.alten.hotel.commons.exception;

public enum RepositoryErrorCode
{
    COD0001("COD0001"),
    COD0002("COD0002"),
    COD0003("COD0003"),
    COD0004("COD0004"),
    COD0005("COD0005"),
    COD0006("COD0006"),
    COD0007("COD0007"),
    COD0008("COD0008");

    private final String code;

    RepositoryErrorCode(String code) { this.code = code; }

    public String getCode() { return code; }
}
