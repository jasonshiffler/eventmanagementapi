package com.shiffler.springrest.eventmanagementapi.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
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


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    //Exposing the id field so we can view it
    public Long getResourceId(){
        return id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venue venue = (Venue) o;
        return id.equals(venue.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
