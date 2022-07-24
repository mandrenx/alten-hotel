package com.alten.hotel.modules.guest.model;

import com.alten.hotel.modules.guest.type.EntryRegisterType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "guest")
public class Guest implements Serializable
{
    @Serial
    private static final long serialVersionUID = -629252817086178746L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idgst", updatable = false, nullable = false)
    private UUID uuid;

    @Column(name = "firstname", length = 50)
    private String firstname;

    @Column(name = "lastname", length = 50)
    private String lastname;

    @Column(name = "email", length = 30)
    private String email;

    @Column(name = "phone", length = 15)
    private String phoneNumber;

    @Column(name = "entry_type", length = 10)
    @Enumerated(EnumType.STRING)
    private EntryRegisterType registerType;

    @Column(name = "people_qnt")
    private Integer peopleQnty;

    @Column(name = "registered_at")
    private LocalDateTime registeredAT;

    @Column(name = "updated_at")
    private LocalDateTime updatedAT;

    public Guest() { }

    public UUID getUuid() { return uuid; }
    public void setUuid(UUID uuid) { this.uuid = uuid; }
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public Integer getPeopleQnty() { return peopleQnty; }
    public void setPeopleQnty(Integer peopleQnty) { this.peopleQnty = peopleQnty; }
    public EntryRegisterType getRegisterType() { return registerType; }
    public void setRegisterType(EntryRegisterType registerType) { this.registerType = registerType; }
    public LocalDateTime getRegisteredAT() { return registeredAT; }
    public void setRegisteredAT(LocalDateTime registeredAT) { this.registeredAT = registeredAT; }
    public LocalDateTime getUpdatedAT() { return updatedAT; }
    public void setUpdatedAT(LocalDateTime updatedAT) { this.updatedAT = updatedAT; }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Guest guest = (Guest) o;

        return new EqualsBuilder().append(getUuid(), guest.getUuid()).append(getFirstname(), guest.getFirstname()).append(getLastname(), guest.getLastname()).append(getEmail(), guest.getEmail()).append(getPhoneNumber(), guest.getPhoneNumber()).append(getRegisterType(), guest.getRegisterType()).append(getPeopleQnty(), guest.getPeopleQnty()).append(getRegisteredAT(), guest.getRegisteredAT()).append(getUpdatedAT(), guest.getUpdatedAT()).isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37).append(getFirstname()).append(getLastname()).append(getEmail()).append(getPhoneNumber()).append(getRegisterType()).append(getPeopleQnty()).append(getRegisteredAT()).toHashCode();
    }
}
