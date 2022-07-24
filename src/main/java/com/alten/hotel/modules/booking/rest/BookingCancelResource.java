package com.alten.hotel.modules.booking.rest;

import com.alten.hotel.modules.booking.resource.BookingResponse;
import com.alten.hotel.modules.booking.service.BookingCancelService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestQuery;
import org.jboss.resteasy.reactive.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/bookings/cancel")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "bookings", description = "Endpoint to cancel a booking")
public class BookingCancelResource
{
    private static final Logger logger = LoggerFactory.getLogger(BookingCancelResource.class);

    @Inject BookingCancelService service;

    @DELETE
    @Operation(description = "Cancel a booking")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Cancel a booking",
                    content = @Content(schema = @Schema(implementation = BookingResponse.class))),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<BookingResponse> cancel(@Parameter(required = true) @RestQuery("bookingID") UUID bookingID)
    {
        this.service.cancel(bookingID);
        logger.info("Booking canceled with ID: {}", bookingID);
        return RestResponse.ResponseBuilder
                .ok(BookingResponse.build())
                .build();
    }
}
