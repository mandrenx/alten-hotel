package com.alten.hotel.modules.integration.rest;

import com.alten.hotel.modules.integration.resource.BookingGuestRequest;
import com.alten.hotel.modules.integration.resource.BookingGuestResponse;
import com.alten.hotel.modules.integration.serializer.BookingGuestSerializer;
import com.alten.hotel.modules.integration.service.BookingGuestCreateService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/integrations/create")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "integrations", description = "Endpoint to save a new Bedroom")
public class BookingGuestCreateResource
{
    private static final Logger logger = LoggerFactory.getLogger(BookingGuestCreateResource.class);

    @Inject BookingGuestSerializer serializer;

    @Inject BookingGuestCreateService service;

    @POST
    @Path("/booking-guest")
    @Operation(description = "Save a new BookingGuest")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Save a new BookingGuest",
                    content = @Content(schema = @Schema(implementation = BookingGuestResponse.class))),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<BookingGuestResponse> createBookingGuest(@Valid BookingGuestRequest request)
    {
        var bookingGuest = this.serializer.toEntity(request);
        var response = this.serializer.toResponse(
                this.service.create(bookingGuest)
        );
        logger.info("create | Response: {}", response);
        return RestResponse.ResponseBuilder
                .ok(response)
                .build();
    }
}
