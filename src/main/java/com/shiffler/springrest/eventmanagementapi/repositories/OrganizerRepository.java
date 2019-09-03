package com.shiffler.springrest.eventmanagementapi.repositories;

import com.shiffler.springrest.eventmanagementapi.entities.Organizer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long> {

    //public List<Organizer> findByName(@Param("name") String name);

    //This is how you make the query defined above pageable
    Page<Organizer> findByName(@Param("name") String name, Pageable pageable);

}
