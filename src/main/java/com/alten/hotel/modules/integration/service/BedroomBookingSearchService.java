package com.alten.hotel.modules.integration.service;

import com.alten.hotel.commons.service.BaseService;
import com.alten.hotel.modules.integration.model.BedroomBooking;
import com.alten.hotel.modules.integration.repository.BedroomBookingRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class BedroomBookingSearchService implements BaseService<BedroomBooking>
{
    @Inject BedroomBookingRepository repo;

    public BedroomBooking findByBedroomID(UUID bedroomID) { return this.repo.findByBedroomID(bedroomID); }

    public BedroomBooking findByBookingID(UUID bookingID) { return this.repo.findByBookingID(bookingID); }
}
