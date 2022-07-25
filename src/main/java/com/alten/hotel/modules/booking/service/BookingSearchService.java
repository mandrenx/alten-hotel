package com.alten.hotel.modules.booking.service;

import com.alten.hotel.modules.booking.model.Booking;
import com.alten.hotel.modules.booking.repository.BookingRepository;
import com.alten.hotel.modules.booking.resource.BookingParameter;
import com.alten.hotel.modules.booking.resource.BookingParameterRequest;
import com.alten.hotel.modules.booking.type.AccommodationType;
import com.alten.hotel.modules.booking.type.BookingOperationType;
import com.alten.hotel.modules.booking.type.BookingStatusType;
import com.alten.hotel.modules.guest.exception.errors.BookingError;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@ApplicationScoped
public class BookingSearchService implements BookingService
{
    @Inject BookingRepository repo;

    public Booking findByAccommodation(String accommodation)
    {
        return this.execute(
                this.repo,
                new BookingParameterRequest(
                        BookingOperationType.FIND_BOOKING_BY_ACCOMMODATION,
                        new BookingParameter(
                                null,
                                AccommodationType.valueOf(accommodation),
                                null,
                                null
                        ),
                        null
                )
        ).entity();
    }

    private void validatePeriodForBooking(LocalDateTime entryAT, LocalDateTime exitAT)
    {
        var previousDays = Period.between(LocalDateTime.now().toLocalDate(), entryAT.toLocalDate()).getDays();
        var hostedDays = Period.between(entryAT.toLocalDate(), exitAT.toLocalDate()).getDays();

        if (previousDays > 30) this.throwBookingException(BookingError.BKG0006);
        if (hostedDays > 3) this.throwBookingException(BookingError.BKG0007);
    }

    public List<Booking> findByAvailable(String firstDay, String lastDay)
    {
        var entryAT = this.toLocalDateTime(firstDay);
        var exitAT = this.toLocalDateTime(lastDay);

        this.validatePeriodForBooking(entryAT, exitAT);

        return this.execute(
                this.repo,
                new BookingParameterRequest(
                        BookingOperationType.FIND_BOOKING_BY_AVAILABLE,
                        new BookingParameter(
                                null,
                                null,
                                entryAT,
                                exitAT
                        ),
                        null
                )
        ).list();
    }

    public List<Booking> findByStatus(String status)
    {
        return this.execute(
                this.repo,
                new BookingParameterRequest(
                        BookingOperationType.FIND_BOOKING_BY_STATUS,
                        new BookingParameter(
                                BookingStatusType.valueOf(status),
                                null,
                                null,
                                null
                        ),
                        null
                )
        ).list();
    }
}
