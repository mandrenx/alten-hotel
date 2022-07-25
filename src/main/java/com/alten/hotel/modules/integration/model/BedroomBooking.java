package com.alten.hotel.modules.integration.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
    public void setUuid(UUID uuid) { this.uuid = uuid; }
    public UUID getBedroomID() { return bedroomID; }
    public void setBedroomID(UUID bedroomID) { this.bedroomID = bedroomID; }
    public UUID getBookingID() { return bookingID; }
    public void setBookingID(UUID bookingID) { this.bookingID = bookingID; }
    public LocalDateTime getAddedAT() { return addedAT; }
    public void setAddedAT(LocalDateTime addedAT) { this.addedAT = addedAT; }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        BedroomBooking that = (BedroomBooking) o;

        return new EqualsBuilder().append(getUuid(), that.getUuid()).append(getBedroomID(), that.getBedroomID()).append(getBookingID(), that.getBookingID()).append(getAddedAT(), that.getAddedAT()).isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37).append(getBedroomID()).append(getBookingID()).append(getAddedAT()).toHashCode();
    }
}
