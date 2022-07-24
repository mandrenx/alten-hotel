package com.alten.hotel.modules.integration.repository;

import com.alten.hotel.commons.repository.BaseRepository;
import com.alten.hotel.modules.integration.model.BedroomBooking;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class BedroomBookingRepository implements BaseRepository<BedroomBooking>
{
    public BedroomBooking findByBookingID(UUID bookingID) { return this.searchByID("bookingID", bookingID); }

    public BedroomBooking findByBedroomID(UUID bedroomID) { return this.searchByID("bedroomID", bedroomID); }
}
