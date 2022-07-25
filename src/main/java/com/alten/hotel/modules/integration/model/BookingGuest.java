package com.alten.hotel.modules.integration.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
    public void setUuid(UUID uuid) { this.uuid = uuid; }
    public UUID getBookingID() { return bookingID; }
    public void setBookingID(UUID bookingID) { this.bookingID = bookingID; }
    public UUID getGuestID() { return guestID; }
    public void setGuestID(UUID guestID) { this.guestID = guestID; }
    public LocalDateTime getAddedAT() { return addedAT; }
    public void setAddedAT(LocalDateTime addedAT) { this.addedAT = addedAT; }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        BookingGuest that = (BookingGuest) o;

        return new EqualsBuilder().append(getUuid(), that.getUuid()).append(getBookingID(), that.getBookingID()).append(getGuestID(), that.getGuestID()).append(getAddedAT(), that.getAddedAT()).isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37).append(getBookingID()).append(getGuestID()).append(getAddedAT()).toHashCode();
    }
}
