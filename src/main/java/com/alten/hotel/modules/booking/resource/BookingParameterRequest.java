package com.alten.hotel.modules.booking.resource;

import com.alten.hotel.modules.booking.model.Booking;
import com.alten.hotel.modules.booking.type.BookingOperationType;

public record BookingParameterRequest(BookingOperationType operation,
                                      BookingParameter parameter,
                                      Booking guest) { }
