package com.shiffler.springrest.eventmanagementapi.repositories;

import com.shiffler.springrest.eventmanagementapi.entities.Event;
import org.springframework.data.repository.PagingAndSortingRepository;


//PagingAndSortingRepository extends CrudRepository and gives us extra functionality
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
}
