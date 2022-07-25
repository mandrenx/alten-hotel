package com.alten.hotel.modules.integration.service;

import com.alten.hotel.commons.service.BaseService;
import com.alten.hotel.modules.integration.model.BookingGuest;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class BookingGuestCreateService implements BaseService<BookingGuest>
{
    @Transactional
    public BookingGuest create(BookingGuest request) { return this.insertUpdate(request); }
}
