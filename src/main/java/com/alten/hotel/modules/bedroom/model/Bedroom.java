package com.alten.hotel.modules.bedroom.model;

import com.alten.hotel.modules.bedroom.type.BedroomStatusType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "bedroom")
public class Bedroom implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1310437853399132166L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idrm", updatable = false, nullable = false)
    private UUID uuid;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "apt_numb", length = 10)
    private String aptNumber;

    @Column(name = "status", length = 20)
    @Enumerated(EnumType.STRING)
    private BedroomStatusType status;

    public Bedroom() { }

    public UUID getUuid() { return uuid; }
    public void setUuid(UUID uuid) { this.uuid = uuid; }
    public Integer getFloor() { return floor; }
    public void setFloor(Integer floor) { this.floor = floor; }
    public String getAptNumber() { return aptNumber; }
    public void setAptNumber(String aptNumber) { this.aptNumber = aptNumber; }
    public BedroomStatusType getStatus() { return status; }
    public void setStatus(BedroomStatusType status) { this.status = status; }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Bedroom bedroom = (Bedroom) o;

        return new EqualsBuilder().append(getUuid(), bedroom.getUuid()).append(getFloor(), bedroom.getFloor()).append(getAptNumber(), bedroom.getAptNumber()).append(getStatus(), bedroom.getStatus()).isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37).append(getFloor()).append(getAptNumber()).append(getStatus()).toHashCode();
    }
}
