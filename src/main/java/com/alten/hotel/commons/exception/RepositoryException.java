package com.alten.hotel.commons.exception;

public class RepositoryException extends RuntimeException
{
    public RepositoryException(RepositoryErrorMessage message) { super(message.getMessage()); }
}
