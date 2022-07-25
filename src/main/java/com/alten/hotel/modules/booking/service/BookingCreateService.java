package com.alten.hotel.modules.booking.service;

import com.alten.hotel.modules.booking.internal.service.IntegrationService;
import com.alten.hotel.modules.booking.model.Booking;
import com.alten.hotel.modules.booking.repository.BookingRepository;
import com.alten.hotel.modules.booking.resource.BookingParameterRequest;
import com.alten.hotel.modules.booking.type.BookingOperationType;
import com.alten.hotel.modules.guest.exception.errors.BookingError;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
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
        return Stream.of(booking.getStatus(), booking.getAccommodation(),
                booking.getEntryAT(), booking.getExitAT(), booking.getRegisteredAT()).allMatch(Objects::isNull);
    }

    @Transactional
    public Booking create(UUID bedroomID, UUID guestID, Booking request)
    {
        if (this.verifyBookingData(request)) this.throwBookingException(BookingError.BKG0002);

        request.setEntryAT(LocalDateTime.now().withHour(0).withMinute(0).withSecond(0));
        request.setExitAT(LocalDateTime.now().withHour(23).withMinute(59).withSecond(59));

        var booking = this.execute(this.repo,
                new BookingParameterRequest(
                        BookingOperationType.CREATE_UPDATE_BOOKING,
                        null,
                        request
                )
        ).entity();

        this.integrationService.createBookingGuestAndBedroomBooking(bedroomID, booking.getUuid(), guestID);

        return booking;
    }
}
