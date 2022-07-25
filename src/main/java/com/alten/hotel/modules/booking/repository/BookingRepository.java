package com.alten.hotel.modules.booking.repository;

import com.alten.hotel.commons.repository.BaseRepository;
import com.alten.hotel.modules.booking.model.Booking;
import com.alten.hotel.modules.booking.type.AccommodationType;
import com.alten.hotel.modules.booking.type.BookingStatusType;
import com.blazebit.persistence.CriteriaBuilderFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class BookingRepository implements BaseRepository<Booking>
{
    @Inject EntityManager em;

    @Inject CriteriaBuilderFactory cbf;

    public Booking findByID(UUID uuid) { return this.searchByID("idbkg", uuid); }

    public List<Booking> findByStatus(BookingStatusType status) { return this.searchList("status", status); }

    public List<Booking> findByAccommodation(AccommodationType accommodation)
    {
        return this.searchList("accommodation", accommodation);
    }

    public List<Booking> findByPeriod(LocalDateTime entryAT, LocalDateTime exitAT)
    {
        return this.cbf.create(this.em, Booking.class, "b")
                .where("b.entryAT").gt(entryAT)
                .where("b.exitAT").lt(exitAT)
                .getResultList();
    }
}
