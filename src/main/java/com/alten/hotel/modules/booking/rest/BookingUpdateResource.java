package com.alten.hotel.modules.booking.rest;

import com.alten.hotel.modules.booking.resource.BookingRequest;
import com.alten.hotel.modules.booking.resource.BookingResponse;
import com.alten.hotel.modules.booking.serializer.BookingResourceSerializer;
import com.alten.hotel.modules.booking.service.BookingUpdateService;
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

@Path("/bookings/update")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "bookings", description = "Endpoints to update booking data")
public class BookingUpdateResource
{
    private static final Logger logger = LoggerFactory.getLogger(BookingUpdateResource.class);

    @Inject BookingResourceSerializer serializer;

    @Inject BookingUpdateService service;

    @POST
    @Operation(description = "Update booking data")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "204",
                    description = "Update booking data",
                    content = @Content(schema = @Schema(implementation = BookingResponse.class))),
            @APIResponse(responseCode = "404", description = "Booking not found"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<BookingResponse> update(@Parameter(required = true) @RestQuery("uuidRequest") String uuidRequest,
                                                @Valid BookingRequest request)
    {
        var response = this.serializer.toResponse(
                this.service.update(
                        uuidRequest, this.serializer.toEntity(request)
                )
        );
        logger.info("update | Response: {}", response);
        return RestResponse.ResponseBuilder
                .ok(response)
                .build();
    }
}
