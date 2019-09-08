package com.shiffler.springrest.eventmanagementapi.entities;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Venue extends AbstractEntity {

    private String name;

    @Column(name = "streetaddress")
    private String streetAddress;

    @Column(name = "streetaddress2")
    private String streetAddress2;

    private String city;

    private String state;

    private String country;

    @Column(name = "postalcode")
    private String postalCode;

    //Exposing the id field so we can view it
    public Long getResourceId(){
        return id;
    }

}