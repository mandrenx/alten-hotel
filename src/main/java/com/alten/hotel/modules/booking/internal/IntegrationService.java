package com.alten.hotel.modules.booking.internal;

import com.alten.hotel.modules.integration.resource.BedroomBookingRequest;
import com.alten.hotel.modules.integration.resource.BookingGuestRequest;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
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

    public void create(UUID bedroomID, UUID bookingID, UUID guestID)
    {
        this.client.createBookingGuest(
                new BookingGuestRequest(
                        null,
                        bookingID,
                        guestID,
                        this.now()
                )
        );

        this.client.createBedroomBooking(
                new BedroomBookingRequest(
                        null,
                        bedroomID,
                        bookingID,
                        this.now()
                )
        );
    }
}
