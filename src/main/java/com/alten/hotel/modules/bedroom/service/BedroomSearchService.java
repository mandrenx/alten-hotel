package com.alten.hotel.modules.bedroom.service;

import com.alten.hotel.commons.service.BaseService;
import com.alten.hotel.modules.bedroom.model.Bedroom;
import com.alten.hotel.modules.bedroom.type.BedroomStatusType;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class BedroomSearchService implements BaseService<Bedroom>
{
    public Bedroom findByNumber(String aptNumber) { return this.search("aptNumber", aptNumber); }

    public List<Bedroom> findByFloor(Integer floor) { return this.searchList("floor", floor); }

    public List<Bedroom> findByAvailable(String status)
    {
        return this.searchList("status", BedroomStatusType.valueOf(status));
    }
}
