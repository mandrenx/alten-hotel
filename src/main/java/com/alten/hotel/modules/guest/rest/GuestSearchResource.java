package com.alten.hotel.modules.guest.rest;

import com.alten.hotel.modules.guest.resource.GuestResponse;
import com.alten.hotel.modules.guest.serializer.GuestResourceSerializer;
import com.alten.hotel.modules.guest.service.GuestSearchService;
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

@Path("/guests/search")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "guests", description = "Endpoints to search guests")
public class GuestSearchResource
{
    private static final Logger logger = LoggerFactory.getLogger(GuestSearchResource.class);

    @Inject GuestResourceSerializer serializer;

    @Inject GuestSearchService service;

    @GET
    @Path("/email")
    @Operation(description = "Find a guest by email")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Find guest by email",
                    content = @Content(schema = @Schema(implementation = GuestResponse.class))),
            @APIResponse(responseCode = "404", description = "Guest not found"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<GuestResponse> findByEmail(@Parameter(required = true) @RestQuery("email") String email)
    {
        var response = this.serializer.toResponse(
                this.service.findByEmail(email)
        );
        logger.info("findByEmail | Response: {}", response.firstname() + " | " + response.lastname());
        return RestResponse.ResponseBuilder
                .ok(response)
                .build();
    }

    @Operation(summary = "Find a guest by full name")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Find a guest by full name",
                    content = @Content(schema = @Schema(implementation = GuestResponse.class))),
            @APIResponse(responseCode = "404", description = "guest not found"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GET
    @Path("/full-name")
    public RestResponse<GuestResponse> findByFullName(
            @Parameter(required = true) @RestQuery("firstname") String firstname,
            @Parameter(required = true) @RestQuery("lastname") String lastname)
    {
        var response = this.serializer.toResponse(
                this.service.findByFullName(firstname, lastname)
        );
        logger.info("findByFullName | Response: {}", response.firstname() + " | " + response.lastname());
        return RestResponse.ResponseBuilder
                .ok(response)
                .build();
    }

    @GET
    @Path("/phone")
    @Operation(description = "Find guest by phoneNumber")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Find guest by phoneNumber",
                    content = @Content(schema = @Schema(implementation = GuestResponse.class))),
            @APIResponse(responseCode = "404", description = "Guest not found"),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<GuestResponse> findByPhoneNumber(@Parameter(required = true) @RestQuery("phoneNumber") String phoneNumber)
    {
        var response = this.serializer.toResponse(
                this.service.findByPhoneNumber(phoneNumber)
        );
        logger.info("findByPhoneNumber | Response: {}", response.firstname() + " | " + response.lastname());
        return RestResponse.ResponseBuilder
                .ok(response)
                .build();
    }
}
