package com.shiffler.springrest.eventmanagementapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;
import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

//Allows us to define which parts of the JSON record are displayed first.
@JsonPropertyOrder({"resourceId"})
@Entity
@Data
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

    //Exposing the id field so we can view it
    public Long getResourceId(){
        return id;
    }

}