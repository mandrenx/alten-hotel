package com.alten.hotel.modules.booking.service;

import com.alten.hotel.modules.booking.internal.IntegrationService;
import com.alten.hotel.modules.booking.repository.BookingRepository;
import com.alten.hotel.modules.booking.resource.BookingParameterRequest;
import com.alten.hotel.modules.booking.type.BookingOperationType;
import com.alten.hotel.modules.booking.type.BookingStatusType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class BookingCancelService implements BookingService
{
    @Inject BookingRepository repo;

    @Inject IntegrationService integrationService;

    public void cancel(UUID uuid)
    {
        var booking = this.repo.findByID(uuid);
        booking.setStatus(BookingStatusType.CANCELED);
        booking.setUpdatedAT(this.getFormattedDate());
        this.execute(
                this.repo,
                new BookingParameterRequest(
                        BookingOperationType.CREATE_UPDATE_BOOKING,
                        null,
                        booking
                )
        ).entity();
    }
}
