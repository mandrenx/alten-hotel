package com.alten.hotel.modules.guest.resource;

import java.util.Optional;

public record GuestParameter(Optional<String> firstname,
                             Optional<String> lastname,
                             Optional<String> email,
                             Optional<String> phoneNumber) { }
