package com.alten.hotel.modules.bedroom.rest;

import com.alten.hotel.modules.bedroom.resource.BedroomResponse;
import com.alten.hotel.modules.bedroom.serializer.BedroomSerializer;
import com.alten.hotel.modules.bedroom.service.BedroomUpdateService;
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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/bedrooms/update")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "bedrooms", description = "Endpoint to update bedroom data")
public class BedroomUpdateResource
{
    private static final Logger logger = LoggerFactory.getLogger(BedroomUpdateResource.class);

    @Inject BedroomSerializer serializer;

    @Inject BedroomUpdateService service;

    @PUT
    @Operation(description = "Update a bedroom data")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Update a bedroom data",
                    content = @Content(schema = @Schema(implementation = BedroomResponse.class))),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<BedroomResponse> update(@Parameter(required = true) @RestQuery("status") String status,
                                                @Parameter(required = true) @RestQuery("uuid") UUID uuid)
    {
        var response = this.serializer.toResponse(
                this.service.update(uuid, status)
        );
        logger.info("Response: {}", response);
        return RestResponse.ResponseBuilder
                .ok(response)
                .build();
    }
}
