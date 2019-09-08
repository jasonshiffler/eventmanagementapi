package com.shiffler.springrest.eventmanagementapi.entities;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
public class Participant extends AbstractEntity{

    //This is a mandatory field
    @Column(nullable = false)
    private String name;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(name="checkedin")
    private Boolean checkedIn;

    //Many participants can be part of one event
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", nullable = false, updatable = false)
    private Event event;

    //Exposing the id field so we can view it
    public Long getResourceId(){
        return id;
    }

}