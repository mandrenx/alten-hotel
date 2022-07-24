package com.alten.hotel.modules.booking.internal;

import com.alten.hotel.modules.integration.resource.BedroomBookingRequest;
import com.alten.hotel.modules.integration.resource.BedroomBookingResponse;
import com.alten.hotel.modules.integration.resource.BookingGuestRequest;
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
    @Path("/bedroom-booking")
    BedroomBookingResponse createBedroomBooking(BedroomBookingRequest request);

    @POST
    @Path("/booking-guest")
    BookingGuestResponse createBookingGuest(BookingGuestRequest request);

    @GET
    @Path("/search/bookings")
    BookingGuestResponse findByBookingID(@RestQuery("bookingID") UUID bookingID);
}
