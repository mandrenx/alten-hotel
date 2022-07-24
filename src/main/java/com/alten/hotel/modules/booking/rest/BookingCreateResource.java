package com.alten.hotel.modules.booking.rest;

import com.alten.hotel.modules.booking.resource.BookingRequest;
import com.alten.hotel.modules.booking.resource.BookingResponse;
import com.alten.hotel.modules.booking.serializer.BookingResourceSerializer;
import com.alten.hotel.modules.booking.service.BookingCreateService;
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
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/bookings/create")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "bookings", description = "Endpoint to save a new booking")
public class BookingCreateResource
{
    private static final Logger logger = LoggerFactory.getLogger(BookingCreateResource.class);

    @Inject BookingResourceSerializer serializer;

    @Inject BookingCreateService service;

    @POST
    @Operation(description = "Save a new booking")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Save a new booking",
                    content = @Content(schema = @Schema(implementation = BookingResponse.class))),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<BookingResponse> create(@Parameter(required = true) @RestQuery("bedroomID") UUID bedroomID,
                                                @Parameter(required = true) @RestQuery("guestID") UUID guestID,
                                                @Valid BookingRequest request)
    {
        var response = this.serializer.toResponse(
                this.service.create(
                        guestID,
                        bedroomID,
                        this.serializer.toEntity(request)
                )
        );
        logger.info("create | Response: {}", response);
        return RestResponse.ResponseBuilder
                .ok(response)
                .build();
    }
}
