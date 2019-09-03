package com.shiffler.springrest.eventmanagementapi.repositories;

import com.shiffler.springrest.eventmanagementapi.entities.Participant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ParticipantRepository extends PagingAndSortingRepository<Participant,Long> {
}
