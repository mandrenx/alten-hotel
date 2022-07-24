package com.alten.hotel.modules.booking.repository;

import com.alten.hotel.commons.repository.BaseRepository;
import com.alten.hotel.modules.booking.model.Booking;
import com.alten.hotel.modules.booking.type.AccommodationType;
import com.alten.hotel.modules.booking.type.BookingStatusType;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class BookingRepository implements BaseRepository<Booking>
{
    public Booking findByID(UUID uuid) { return this.searchByID("idbkg", uuid); }

    public List<Booking> findByStatus(BookingStatusType status) { return this.searchList("status", status); }

    public List<Booking> findByAccommodation(AccommodationType accommodation)
    {
        return this.searchList("accommodation", accommodation);
    }

    public List<Booking> findByPeriod(LocalDateTime entryAT, LocalDateTime exitAT)
    {
        return this.searchList(
                "entryAT = :entryAT and exitAT = :exitAT",
                Parameters
                        .with("entryAT", entryAT)
                        .and("exit", exitAT));
    }
}
