package com.alten.hotel.modules.booking.internal.service;

import com.alten.hotel.modules.booking.internal.resource.BedroomIntegrationRequest;
import com.alten.hotel.modules.booking.internal.resource.BookingIntegrationRequest;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@ApplicationScoped
public class IntegrationService
{
    @RestClient IntegrationClient client;

    private LocalDateTime now()
    {
        return LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
    }

    @Transactional
    public void create(UUID bedroomID, UUID bookingID, UUID guestID)
    {
        this.client.createBookingGuest(
                new BookingIntegrationRequest(null, bookingID, guestID, this.now())
        );

        this.client.createBedroomBooking(
                new BedroomIntegrationRequest(null, bedroomID, bookingID, this.now())
        );
    }
}
