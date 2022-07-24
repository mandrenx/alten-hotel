package com.alten.hotel.modules.integration.model;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "bedroom_booking")
public class BedroomBooking implements Serializable
{
    @Serial
    private static final long serialVersionUID = 6677286786227346798L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idbbi", updatable = false, nullable = false)
    private UUID uuid;

    @Column(name = "bedroom_id")
    private UUID bedroomID;

    @Column(name = "booking_id")
    private UUID bookingID;

    @Column(name = "added_at")
    private LocalDateTime addedAT;

    public BedroomBooking() { }

    public UUID getUuid() { return uuid; }
    public UUID getBookingID() { return bookingID; }
    public UUID getBedroomID() { return bedroomID; }
    public LocalDateTime getAddedAT() { return addedAT; }
}
