package com.alten.hotel.modules.integration.service;

import com.alten.hotel.commons.service.BaseService;
import com.alten.hotel.modules.integration.model.BedroomBooking;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class BedroomBookingCreateService implements BaseService<BedroomBooking>
{
    @Transactional
    public BedroomBooking create(BedroomBooking bedroomBooking) { return this.insertUpdate(bedroomBooking); }
}
