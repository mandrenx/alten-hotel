package com.alten.hotel.modules.integration.repository;

import com.alten.hotel.commons.repository.BaseRepository;
import com.alten.hotel.modules.integration.model.BookingGuest;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class BookingGuestRepository implements BaseRepository<BookingGuest>
{
    public BookingGuest findByBookingID(UUID bookingID) { return this.searchByID("bookingID", bookingID); }

    public BookingGuest findByGuestID(UUID guestID) { return this.searchByID("guestID", guestID); }
}
