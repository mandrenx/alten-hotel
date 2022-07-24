package com.alten.hotel.modules.booking.service;

import com.alten.hotel.modules.booking.model.Booking;
import com.alten.hotel.modules.booking.repository.BookingRepository;
import com.alten.hotel.modules.booking.resource.BookingParameterRequest;
import com.alten.hotel.modules.booking.serializer.BookingSerializer;
import com.alten.hotel.modules.booking.type.BookingOperationType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@ApplicationScoped
public class BookingUpdateService implements BookingService
{
    @Inject BookingRepository repo;

    @Inject BookingSerializer serializer;

    private void updateEntity(UUID uuid, Booking request, Booking booking)
    {
        this.serializer.update(request, booking);
        booking.setUuid(uuid);
        booking.setUpdatedAT(LocalDateTime.parse(
            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))
        ));
    }

    @Transactional
    public Booking update(String uuidRequest, Booking request)
    {
        var uuid = this.toUUID(uuidRequest);
        var booking = this.repo.findByID(uuid);
        this.updateEntity(uuid, request, booking);
        return this.execute(
                this.repo,
                new BookingParameterRequest(
                        BookingOperationType.CREATE_UPDATE_BOOKING,
                        null,
                        booking
                )
        ).entity();
    }
}
