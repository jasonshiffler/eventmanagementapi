package com.shiffler.springrest.eventmanagementapi.entities.Projections;


import com.shiffler.springrest.eventmanagementapi.entities.Venue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;


//Example of a Virtual projection where two fields are combined into one for display
@Projection(name ="virtual", types = {Venue.class})
public interface StreetAddressProjection {

    @Value("#{target.streetAddress} #{target.streetAddress2}")
    String getCompleteStreetAddress();

}
