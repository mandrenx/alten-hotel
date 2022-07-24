package com.alten.hotel.modules.guest.resource;

import com.alten.hotel.modules.guest.model.Guest;
import com.alten.hotel.modules.guest.type.GuestOperationType;

public record GuestParameterRequest(GuestOperationType operation,
                                    GuestParameter parameter,
                                    Guest guest) { }
