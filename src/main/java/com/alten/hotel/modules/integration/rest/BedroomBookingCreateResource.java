package com.alten.hotel.modules.integration.rest;

import com.alten.hotel.modules.integration.resource.BedroomBookingRequest;
import com.alten.hotel.modules.integration.resource.BedroomBookingResponse;
import com.alten.hotel.modules.integration.serializer.BedroomBookingSerializer;
import com.alten.hotel.modules.integration.service.BedroomBookingCreateService;
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
public class BedroomBookingCreateResource
{
    private static final Logger logger = LoggerFactory.getLogger(BedroomBookingCreateResource.class);

    @Inject BedroomBookingSerializer serializer;

    @Inject BedroomBookingCreateService service;

    @POST
    @Path("/bedroom-booking")
    @Operation(description = "Save a new BedroomBooking")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Save a new BedroomBooking",
                    content = @Content(schema = @Schema(implementation = BedroomBookingResponse.class))),
            @APIResponse(responseCode = "500", description = "Internal Server Error")
    })
    public RestResponse<BedroomBookingResponse> createBedroomBooking(@Valid BedroomBookingRequest request)
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
