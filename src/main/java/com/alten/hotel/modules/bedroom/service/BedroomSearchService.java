package com.alten.hotel.modules.bedroom.service;

import com.alten.hotel.commons.service.BaseService;
import com.alten.hotel.modules.bedroom.model.Bedroom;
import com.alten.hotel.modules.bedroom.repository.BedroomRepository;
import com.alten.hotel.modules.bedroom.type.BedroomStatusType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class BedroomSearchService implements BaseService<Bedroom>
{
    @Inject BedroomRepository repo;

    public Bedroom findByNumber(String aptNumber) { return this.repo.findByNumber(aptNumber); }

    public List<Bedroom> findByFloor(Integer floor) { return this.repo.findByFloor(floor); }

    public List<Bedroom> findByAvailable(String status) { return this.repo.findByAvailable(BedroomStatusType.valueOf(status)); }
}
