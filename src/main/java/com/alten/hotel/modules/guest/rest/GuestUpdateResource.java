package com.alten.hotel.modules.guest.rest;

import com.alten.hotel.modules.guest.resource.GuestRequest;
import com.alten.hotel.modules.guest.resource.GuestResponse;
import com.alten.hotel.modules.guest.serializer.GuestResourceSerializer;
import com.alten.hotel.modules.guest.service.GuestUpdateService;
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

@Path("/guests/update")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "guests", description = "Endpoints to update guest data")
public class GuestUpdateResource
{
    private static final Logger logger = LoggerFactory.getLogger(GuestUpdateResource.class);

    @Inject GuestResourceSerializer serializer;

    @Inject GuestUpdateService service;

    @POST
    @Operation(description = "Update guest data")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "204",
                    description = "Update guest data",
                    content = @Content(schema = @Schema(implementation = GuestResponse.class))),
            @APIResponse(responseCode = "404", description = "Guest not found"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<GuestResponse> update(@Parameter(required = true) @RestQuery("uuidRequest") String uuidRequest,
                                              @Valid GuestRequest request)
    {
        var response = this.serializer.toResponse(
                this.service.update(
                        uuidRequest, this.serializer.toEntity(request)
                )
        );
        logger.info("update | Response: {}", response.firstname() + " | " + response.lastname());
        return RestResponse.ResponseBuilder
                .ok(response)
                .build();
    }
}
