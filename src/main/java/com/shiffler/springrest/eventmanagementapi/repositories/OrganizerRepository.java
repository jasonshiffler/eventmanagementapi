package com.shiffler.springrest.eventmanagementapi.repositories;

import com.shiffler.springrest.eventmanagementapi.entities.Organizer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long> {
}
