package com.alten.hotel.modules.integration.rest;

import com.alten.hotel.modules.integration.resource.BookingIntegrationResponse;
import com.alten.hotel.modules.integration.resource.GuestIntegrationResponse;
import com.alten.hotel.modules.integration.service.BookingGuestSearchService;
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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/integrations/search")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "integrations", description = "Endpoints to search integration data")
public class BookingGuestSearchResource
{
    private static final Logger logger = LoggerFactory.getLogger(BookingGuestSearchResource.class);

    @Inject BookingGuestSearchService service;

    @GET
    @Path("/bookings-guests")
    @Operation(description = "Find booking by guest ID")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Find booking by guest ID",
                    content = @Content(schema = @Schema(implementation = BookingIntegrationResponse.class))),
            @APIResponse(responseCode = "404", description = "BookingIntegration not found"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<BookingIntegrationResponse> findBook(
            @Parameter(required = true) @RestQuery("guestID") UUID guestID)
    {
        var booking = this.service.findByGuestID(guestID);
        logger.info("BookingID Response: {}", booking.getBookingID());
        return RestResponse.ResponseBuilder
                .ok(new BookingIntegrationResponse(booking.getBookingID(), booking.getAddedAT()))
                .build();
    }

    @GET
    @Path("/guests")
    @Operation(description = "Find guest by booking ID")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Find guest by booking ID",
                    content = @Content(schema = @Schema(implementation = GuestIntegrationResponse.class))),
            @APIResponse(responseCode = "404", description = "GuestIntegration not found"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<GuestIntegrationResponse> findGuest(
            @Parameter(required = true) @RestQuery("bookingID") UUID bookingID)
    {
        var booking = this.service.findByBookingID(bookingID);
        logger.info("GuestID Response: {}", booking.getGuestID());
        return RestResponse.ResponseBuilder
                .ok(new GuestIntegrationResponse(booking.getGuestID(), booking.getAddedAT()))
                .build();
    }
}
