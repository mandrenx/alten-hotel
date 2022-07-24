package com.alten.hotel.modules.bedroom.service;

import com.alten.hotel.commons.service.BaseService;
import com.alten.hotel.modules.bedroom.model.Bedroom;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BedroomCreateService implements BaseService<Bedroom>
{
    public Bedroom create(Bedroom request) { return this.insertUpdate(request); }
}
