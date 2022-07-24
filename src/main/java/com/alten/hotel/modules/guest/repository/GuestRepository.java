package com.alten.hotel.modules.guest.repository;

import com.alten.hotel.commons.repository.BaseRepository;
import com.alten.hotel.modules.guest.model.Guest;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class GuestRepository implements BaseRepository<Guest>
{
    public Guest findByID(UUID uuid) { return this.searchByID("idgst", uuid); }

    public Guest findByFullName(String firstname, String lastname)
    {
        return this.search(
                "firstname = :firstname and lastname = :lastname",
                Parameters
                        .with("firstname", firstname)
                        .and("lastname", lastname));
    }

    public Guest findByEmail(String email) { return this.search("email", email); }

    public Guest findByPhoneNumber(String phoneNumber) { return this.search("phoneNumber", phoneNumber); }
}
