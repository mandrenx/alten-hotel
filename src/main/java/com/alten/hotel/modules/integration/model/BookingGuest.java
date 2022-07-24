package com.alten.hotel.modules.integration.model;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "booking_guest")
public class BookingGuest implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1310437853399132166L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idbgi", updatable = false, nullable = false)
    private UUID uuid;

    @Column(name = "booking_id")
    private UUID bookingID;

    @Column(name = "guest_id")
    private UUID guestID;

    @Column(name = "added_at")
    private LocalDateTime addedAT;

    public BookingGuest() { }

    public UUID getUuid() { return uuid; }
    public UUID getBookingID() { return bookingID; }
    public UUID getGuestID() { return guestID; }
    public LocalDateTime getAddedAT() { return addedAT; }
}
