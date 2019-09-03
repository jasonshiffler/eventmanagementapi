package com.shiffler.springrest.eventmanagementapi.repositories;

import com.shiffler.springrest.eventmanagementapi.entities.Event;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


//PagingAndSortingRepository extends CrudRepository and gives us extra functionality
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

    public List<Event> findByName(@Param("name") String name);

}
