package com.alten.hotel.modules.bedroom.rest;

import com.alten.hotel.modules.bedroom.resource.BedroomResponse;
import com.alten.hotel.modules.bedroom.serializer.BedroomSerializer;
import com.alten.hotel.modules.bedroom.service.BedroomSearchService;
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

@Path("/bedrooms/search")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "bedrooms", description = "Endpoints to search bedrooms")
public class BedroomSearchResource
{
    private static final Logger logger = LoggerFactory.getLogger(BedroomSearchResource.class);

    @Inject BedroomSerializer serializer;

    @Inject BedroomSearchService service;

    @GET
    @Path("/apt-number")
    @Operation(description = "Find bedroom by number")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Find bedroom by number",
                    content = @Content(schema = @Schema(implementation = BedroomResponse.class))),
            @APIResponse(responseCode = "404", description = "Bedroom number not found"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<BedroomResponse> findByNumber(@Parameter(required = true) @RestQuery("aptNumber") String aptNumber)
    {
        var response = this.serializer.toResponse(
                this.service.findByNumber(aptNumber)
        );
        logger.info("Response: {}", response);
        return RestResponse.ResponseBuilder
                .ok(response)
                .build();
    }

    @GET
    @Path("/floor")
    @Operation(description = "List bedrooms by floor number")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Find guest by booking ID",
                    content = @Content(schema = @Schema(implementation = BedroomResponse.class))),
            @APIResponse(responseCode = "404", description = "Bedroom's floor not found"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<List<BedroomResponse>> findByFloor(@Parameter(required = true) @RestQuery("floor") Integer floor)
    {
        var response = this.serializer.toResponse(
                this.service.findByFloor(floor)
        );
        logger.info("Response: {}", response);
        return RestResponse.ResponseBuilder
                .ok(response)
                .build();
    }

    @GET
    @Path("/status")
    @Operation(description = "List bedrooms by status")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Find guest by status",
                    content = @Content(schema = @Schema(implementation = BedroomResponse.class))),
            @APIResponse(responseCode = "404", description = "Bedroom's status not found"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<List<BedroomResponse>> findByAvailable(@Parameter(required = true) @RestQuery("status") String status)
    {
        var response = this.serializer.toResponse(
                this.service.findByAvailable(status)
        );
        logger.info("Response: {}", response);
        return RestResponse.ResponseBuilder
                .ok(response)
                .build();
    }
}
