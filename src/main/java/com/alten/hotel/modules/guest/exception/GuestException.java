package com.alten.hotel.modules.guest.exception;

import com.alten.hotel.modules.guest.exception.errors.GuestError;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import javax.ws.rs.core.Response;

public class GuestException
{
    @ServerExceptionMapper
    public RestResponse<String> catchingException(GuestCreateUpdateException ex)
    {
        return RestResponse
                .status(Response.Status.INTERNAL_SERVER_ERROR,
                        GuestError.GST0001.getDescription());
    }

    @ServerExceptionMapper
    public RestResponse<String> catchingException(GuestOperationNotAllowedException ex)
    {
        return RestResponse
                .status(Response.Status.INTERNAL_SERVER_ERROR,
                        GuestError.GST0002.getDescription());
    }

    @ServerExceptionMapper
    public RestResponse<String> catchingException(GuestEmailNotFoundException ex)
    {
        return RestResponse
                .status(Response.Status.NOT_FOUND,
                        GuestError.GST0003.getDescription());
    }

    @ServerExceptionMapper
    public RestResponse<String> catchingException(GuestFullNameNotFoundException ex)
    {
        return RestResponse
                .status(Response.Status.NOT_FOUND,
                        GuestError.GST0004.getDescription());
    }

    @ServerExceptionMapper
    public RestResponse<String> catchingException(GuestPhoneNumberNotFoundException ex)
    {
        return RestResponse
                .status(Response.Status.NOT_FOUND,
                        GuestError.GST0005.getDescription());
    }
}
