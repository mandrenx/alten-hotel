package com.alten.hotel.modules.guest.internal;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestQuery;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "booking-api")
public interface BookingClient
{
    @POST
    BookingGuestResponse create(@RestQuery("bookingID") UUID bookingID, BookingGuestRequest request);

    @GET
    @Path("/search/bookings")
    BookingGuestResponse findByBookingID(@RestQuery("bookingID") UUID bookingID);
}
