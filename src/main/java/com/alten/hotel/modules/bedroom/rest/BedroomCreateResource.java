package com.alten.hotel.modules.bedroom.rest;

import com.alten.hotel.modules.bedroom.resource.BedroomRequest;
import com.alten.hotel.modules.bedroom.resource.BedroomResponse;
import com.alten.hotel.modules.bedroom.serializer.BedroomSerializer;
import com.alten.hotel.modules.bedroom.service.BedroomCreateService;
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

@Path("/bedrooms/create")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "bedrooms", description = "Endpoint to save a new Bedroom")
public class BedroomCreateResource
{
    private static final Logger logger = LoggerFactory.getLogger(BedroomCreateResource.class);

    @Inject BedroomSerializer serializer;

    @Inject BedroomCreateService service;

    @POST
    @Operation(description = "Save a new Bedroom")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Save a new Bedroom",
                    content = @Content(schema = @Schema(implementation = BedroomResponse.class))),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<BedroomResponse> create(@Valid BedroomRequest request)
    {
        var response = this.serializer.toResponse(
                this.service.create(
                        this.serializer.toEntity(request)
                )
        );
        logger.info("Response: {}", response);
        return RestResponse.ResponseBuilder
                .ok(response)
                .build();
    }
}
