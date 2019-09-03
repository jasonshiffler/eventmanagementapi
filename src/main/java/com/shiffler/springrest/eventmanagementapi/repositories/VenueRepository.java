package com.shiffler.springrest.eventmanagementapi.repositories;

import com.shiffler.springrest.eventmanagementapi.entities.Venue;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {
}
