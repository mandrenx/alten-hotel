package com.alten.hotel.modules.booking.resource;

import com.alten.hotel.modules.booking.model.Booking;

import java.util.List;

public record BookingResult(Booking entity, List<Booking> list) { }
