package com.alten.hotel.modules.booking.exception;

import com.alten.hotel.modules.guest.exception.errors.BookingError;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import javax.ws.rs.core.Response;

public class BookingException
{
    @ServerExceptionMapper
    public RestResponse<String> catchingException(BookingCreateUpdateException ex)
    {
        return RestResponse
                .status(Response.Status.INTERNAL_SERVER_ERROR,
                        BookingError.BKG0001.getDescription());
    }

    @ServerExceptionMapper
    public RestResponse<String> catchingException(BookingOperationNotAllowedException ex)
    {
        return RestResponse
                .status(Response.Status.INTERNAL_SERVER_ERROR,
                        BookingError.BKG0002.getDescription());
    }

    @ServerExceptionMapper
    public RestResponse<String> catchingException(BookingAccommodationNotFoundException ex)
    {
        return RestResponse
                .status(Response.Status.NOT_FOUND,
                        BookingError.BKG0003.getDescription());
    }

    @ServerExceptionMapper
    public RestResponse<String> catchingException(BookingPeriodNotFoundException ex)
    {
        return RestResponse
                .status(Response.Status.NOT_FOUND,
                        BookingError.BKG0004.getDescription());
    }

    @ServerExceptionMapper
    public RestResponse<String> catchingException(BookingStatusNotFoundException ex)
    {
        return RestResponse
                .status(Response.Status.NOT_FOUND,
                        BookingError.BKG0005.getDescription());
    }
}
