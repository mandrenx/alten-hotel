package com.alten.hotel.modules.guest.rest;

import com.alten.hotel.modules.guest.resource.GuestRequest;
import com.alten.hotel.modules.guest.resource.GuestResponse;
import com.alten.hotel.modules.guest.serializer.GuestResourceSerializer;
import com.alten.hotel.modules.guest.service.GuestCreateService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
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

@Path("/guests/create")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "guests", description = "Endpoints search guests")
public class GuestCreateResource
{
    private static final Logger logger = LoggerFactory.getLogger(GuestCreateResource.class);

    @Inject GuestResourceSerializer serializer;

    @Inject GuestCreateService service;

    @POST
    @Operation(description = "Save a new guest")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Save a new guest",
                    content = @Content(schema = @Schema(implementation = GuestResponse.class))),
            @APIResponse(responseCode = "404", description = "Guest not found"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<GuestResponse> create(@Valid GuestRequest request)
    {
        var response = this.serializer.toResponse(
                this.service.create(
                        this.serializer.toEntity(request)
                )
        );
        logger.info("create | Response: {}", response.firstname() + " " + response.lastname());
        return RestResponse.ResponseBuilder
                .ok(response)
                .build();
    }
}
