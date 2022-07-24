package com.alten.hotel.modules.integration.service;

import com.alten.hotel.commons.service.BaseService;
import com.alten.hotel.modules.integration.model.BedroomBooking;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BedroomBookingCreateService implements BaseService<BedroomBooking>
{
    public BedroomBooking create(BedroomBooking bedroomBooking) { return this.insertUpdate(bedroomBooking); }
}
