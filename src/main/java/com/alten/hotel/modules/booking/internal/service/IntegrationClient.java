package com.alten.hotel.modules.booking.internal.service;

import com.alten.hotel.modules.booking.internal.resource.BedroomIntegrationRequest;
import com.alten.hotel.modules.booking.internal.resource.BookingIntegrationRequest;
import com.alten.hotel.modules.integration.resource.BedroomBookingResponse;
import com.alten.hotel.modules.integration.resource.BookingGuestResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestQuery;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "integration-api")
public interface IntegrationClient
{
    @POST
    @Path("/create/bedroom-booking")
    BedroomBookingResponse createBedroomBooking(BedroomIntegrationRequest request);

    @POST
    @Path("/create/booking-guest")
    BookingGuestResponse createBookingGuest(BookingIntegrationRequest request);

    @GET
    @Path("/search/bookings")
    BookingGuestResponse findByBookingID(@RestQuery("bookingID") UUID bookingID);
}
