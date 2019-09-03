package com.shiffler.springrest.eventmanagementapi.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Participant extends AbstractEntity{


    //This is a mandatory field
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(name="checkedin")
    private Boolean checkedIn;

    //Many participants can be part of one event
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", nullable = false, updatable = false)
    private Event event;


    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    //Exposing the id field so we can view it
    public Long getResourceId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
