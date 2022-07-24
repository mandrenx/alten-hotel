package com.alten.hotel.modules.booking.service;

import com.alten.hotel.modules.booking.internal.IntegrationService;
import com.alten.hotel.modules.booking.model.Booking;
import com.alten.hotel.modules.booking.repository.BookingRepository;
import com.alten.hotel.modules.booking.resource.BookingParameterRequest;
import com.alten.hotel.modules.booking.type.BookingOperationType;
import com.alten.hotel.modules.guest.exception.errors.BookingError;
import com.alten.hotel.modules.integration.resource.BedroomBookingRequest;
import com.alten.hotel.modules.integration.resource.BookingGuestRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Stream;

@ApplicationScoped
public class BookingCreateService implements BookingService
{
    @Inject BookingRepository repo;

    @Inject IntegrationService integrationService;

    private Boolean verifyBookingData(Booking booking)
    {
        return Stream.of(booking.getRoom(), booking.getStatus(), booking.getAccommodation(),
                booking.getEntryAT(), booking.getExitAT(), booking.getRegisteredAT()).allMatch(Objects::isNull);
    }

    public Booking create(UUID bedroomID, UUID guestID, Booking request)
    {
        if (this.verifyBookingData(request)) this.throwBookingException(BookingError.BKG0002);

        request.setEntryAT(request.getRegisteredAT().plusDays(1));
        request.setExitAT(request.getEntryAT().plusDays(2));

        var booking = this.execute(this.repo,
                new BookingParameterRequest(
                        BookingOperationType.CREATE_UPDATE_BOOKING,
                        null,
                        request
                )
        ).entity();

        this.integrationService.create(bedroomID, booking.getUuid(), guestID);

        return booking;
    }
}
