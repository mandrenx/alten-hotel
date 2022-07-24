package com.alten.hotel.modules.booking.rest;

import com.alten.hotel.modules.booking.resource.BookingResponse;
import com.alten.hotel.modules.booking.serializer.BookingResourceSerializer;
import com.alten.hotel.modules.booking.service.BookingSearchService;
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
import java.util.List;

@Path("/booking/search")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "bookings", description = "Endpoints to search bookings")
public class BookingSearchResource
{
    private static final Logger logger = LoggerFactory.getLogger(BookingSearchResource.class);

    @Inject BookingResourceSerializer serializer;

    @Inject BookingSearchService service;

    @GET
    @Path("/accommodation")
    @Operation(description = "List bookings by accommodation")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "List bookings by accommodation",
                    content = @Content(schema = @Schema(implementation = BookingResponse.class))),
            @APIResponse(responseCode = "404", description = "Booking not found"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<BookingResponse> findByAccommodation(
            @Parameter(required = true) @RestQuery("accommodation") String accommodation)
    {
        var response = this.serializer.toResponse(
                this.service.findByAccommodation(accommodation)
        );
        logger.info("findByAccommodation | Response: {}", response);
        return RestResponse.ResponseBuilder
                .ok(response)
                .build();
    }

    @GET
    @Path("/available")
    @Operation(description = "List bookings by available")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "List bookings by available",
                    content = @Content(schema = @Schema(implementation = BookingResponse.class))),
            @APIResponse(responseCode = "404", description = "Booking not found"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<List<BookingResponse>> findByAvailable(
            @Parameter(required = true) @RestQuery("firstDay") String firstDay,
            @Parameter(required = true) @RestQuery("lastDay") String lastDay)
    {
        var response = this.serializer.toResponse(
                this.service.findByAvailable(firstDay, lastDay)
        );
        logger.info("findByAvailable | Response: {}", response);
        return RestResponse.ResponseBuilder
                .ok(response)
                .build();
    }

    @GET
    @Path("/occupation")
    @Operation(description = "List bookings by occupation")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "List bookings by occupation",
                    content = @Content(schema = @Schema(implementation = BookingResponse.class))),
            @APIResponse(responseCode = "404", description = "Booking not found"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<BookingResponse> findByOccupation(@Parameter(required = true) @RestQuery("occupation") String occupation)
    {
        var response = this.serializer.toResponse(
                this.service.findByStatus(occupation)
        );
        logger.info("findByOccupation | Response: {}", response);
        return RestResponse.ResponseBuilder
                .ok(response)
                .build();
    }
}
