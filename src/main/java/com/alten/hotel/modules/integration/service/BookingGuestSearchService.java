package com.alten.hotel.modules.integration.service;

import com.alten.hotel.commons.service.BaseService;
import com.alten.hotel.modules.integration.model.BookingGuest;
import com.alten.hotel.modules.integration.repository.BookingGuestRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class BookingGuestSearchService implements BaseService<BookingGuest>
{
    @Inject BookingGuestRepository repo;

    public BookingGuest findByBookingID(UUID bookingID) { return this.repo.findByBookingID(bookingID); }

    public BookingGuest findByGuestID(UUID guestID) { return this.repo.findByGuestID(guestID); }
}
