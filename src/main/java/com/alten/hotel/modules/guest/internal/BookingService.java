package com.alten.hotel.modules.guest.internal;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.UUID;

@ApplicationScoped
public class BookingService
{
    @RestClient BookingClient client;

    public void create(UUID bookingID, UUID guestUUID)
    {
        this.client.create(
                bookingID,
                new BookingGuestRequest(null, "502", "CONFIRMED", "COUPLE",
                                LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), null)
        );
    }
}
