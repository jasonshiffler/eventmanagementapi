package com.shiffler.springrest.eventmanagementapi.entities.Projections;

import com.shiffler.springrest.eventmanagementapi.entities.Event;
import org.springframework.data.rest.core.config.Projection;

import java.time.Instant;
import java.time.ZonedDateTime;


//Allows us to do a partial projection so that only some of the data within an event is returned
// Ex: http://localhost:8080/events-api/events?projection=partial

@Projection(types={Event.class}, name="partial")
public interface PartialEventProjection {

    String getName();

    ZonedDateTime getStartTime();

    ZonedDateTime getEndTime();

    //Here we can return fields marked with @JsonIgnore
    Instant getCreated();

}
