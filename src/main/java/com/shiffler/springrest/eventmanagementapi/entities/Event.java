package com.shiffler.springrest.eventmanagementapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;


//Allows us to define which parts of the JSON record are displayed first.
@JsonPropertyOrder({"resourceId"})
@Entity
public class Event extends  AbstractEntity {

    private String name;

    //This is used if you need to change the display name of the JSON data
    @JsonProperty("desc")
    private String description;

    @Column(name = "starttime")
    private ZonedDateTime startTime;

    @Column(name = "endtime")
    private ZonedDateTime endTime;

    @Column(name = "zoneid")
    private ZoneId zoneId;
    private Boolean started;

    //An Organizer can have many Events
    //We don't have a cascade type because if we delete an event we don't want to delete an organizer
    //Don't allow an event to not have an organizer
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Organizer organizer;

    //An event can have many participants
    //Orphan Removal - If participants aren't associated with an event delete them.
    //Cascade - if an event is deleted remove the participants
    @JsonIgnore
    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Participant> participants;

    //A venue can have many events
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @RestResource(exported = false)
    private Venue venue;


    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }

    public Boolean getStarted() {
        return started;
    }

    public void setStarted(Boolean started) {
        this.started = started;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }


    //Exposing the id field so we can view it
    public Long getResourceId(){
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id.equals(event.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
