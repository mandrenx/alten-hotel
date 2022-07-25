package com.alten.hotel.modules.booking.model;

import com.alten.hotel.modules.booking.type.AccommodationType;
import com.alten.hotel.modules.booking.type.BookingStatusType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "booking")
public class Booking implements Serializable
{
    @Serial
    private static final long serialVersionUID = 7989553852707548229L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idbkg", updatable = false, nullable = false)
    private UUID uuid;

    @Column(name = "status", length = 20)
    @Enumerated(EnumType.STRING)
    private BookingStatusType status;

    @Column(name = "accommodation", length = 20)
    @Enumerated(EnumType.STRING)
    private AccommodationType accommodation;

    @Column(name = "entry_at")
    private LocalDateTime entryAT;

    @Column(name = "exit_at")
    private LocalDateTime exitAT;

    @Column(name = "registered_at")
    private LocalDateTime registeredAT;

    @Column(name = "updated_at")
    private LocalDateTime updatedAT;

    public Booking() { }

    public UUID getUuid() { return uuid; }
    public void setUuid(UUID uuid) { this.uuid = uuid; }
    public AccommodationType getAccommodation() { return accommodation; }
    public void setAccommodation(AccommodationType accommodation) { this.accommodation = accommodation; }
    public BookingStatusType getStatus() { return status; }
    public void setStatus(BookingStatusType status) { this.status = status; }
    public LocalDateTime getEntryAT() { return entryAT; }
    public void setEntryAT(LocalDateTime entryAT) { this.entryAT = entryAT; }
    public LocalDateTime getExitAT() { return exitAT; }
    public void setExitAT(LocalDateTime exitAT) { this.exitAT = exitAT; }
    public LocalDateTime getRegisteredAT() { return registeredAT; }
    public void setRegisteredAT(LocalDateTime registeredAT) { this.registeredAT = registeredAT; }
    public LocalDateTime getUpdatedAT() { return updatedAT; }
    public void setUpdatedAT(LocalDateTime updatedAT) { this.updatedAT = updatedAT; }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        return new EqualsBuilder().append(getUuid(), booking.getUuid()).append(getStatus(), booking.getStatus()).append(getAccommodation(), booking.getAccommodation()).append(getEntryAT(), booking.getEntryAT()).append(getExitAT(), booking.getExitAT()).append(getRegisteredAT(), booking.getRegisteredAT()).append(getUpdatedAT(), booking.getUpdatedAT()).isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37).append(getStatus()).append(getAccommodation()).append(getEntryAT()).append(getExitAT()).append(getRegisteredAT()).toHashCode();
    }
}
