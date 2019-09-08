package com.shiffler.springrest.eventmanagementapi.repositories;

import com.shiffler.springrest.eventmanagementapi.entities.Event;
import com.shiffler.springrest.eventmanagementapi.entities.Projections.PartialEventProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


//PagingAndSortingRepository extends CrudRepository and gives us extra functionality

//This annotation applies this projection to anything related to this repository
//Only applies for collection data. A single returned event will provide all the exposed fields.
@RepositoryRestResource(excerptProjection = PartialEventProjection.class)
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

    public List<Event> findByName(@Param("name") String name);

}
