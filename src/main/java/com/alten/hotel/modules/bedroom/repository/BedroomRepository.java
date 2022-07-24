package com.alten.hotel.modules.bedroom.repository;

import com.alten.hotel.commons.repository.BaseRepository;
import com.alten.hotel.modules.bedroom.model.Bedroom;
import com.alten.hotel.modules.bedroom.type.BedroomStatusType;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class BedroomRepository implements BaseRepository<Bedroom>
{
    public Bedroom findByNumber(String aptNumber) { return this.search("aptNumber", aptNumber); }

    public List<Bedroom> findByFloor(Integer floor) { return this.searchList("floor", floor); }

    public List<Bedroom> findByAvailable(BedroomStatusType status) { return this.searchList("status", status); }
}
