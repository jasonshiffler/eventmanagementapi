package com.shiffler.springrest.eventmanagementapi.controllers;

import com.shiffler.springrest.eventmanagementapi.entities.Event;
import com.shiffler.springrest.eventmanagementapi.entities.Participant;
import com.shiffler.springrest.eventmanagementapi.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Part;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;

@RepositoryRestController
@RequestMapping("/events")
public class CheckInController {

    private final ParticipantRepository participantRepository;

    @Autowired
    public CheckInController(ParticipantRepository participantRepository){
        this.participantRepository = participantRepository;
    }


    @PostMapping("/checkin/{id}")
    public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id,
                                                            PersistentEntityResourceAssembler assembler) {

        Optional<Participant> optionalParticipant = participantRepository.findById(id);
        Participant participant;

        if (optionalParticipant.isPresent()) {
            participant = optionalParticipant.get();

            if (participant.getCheckedIn()) {
                throw new AlreadyCheckedInException();
            }
            participant.setCheckedIn(true);
            participantRepository.save(participant);
            return ResponseEntity.ok(assembler.toResource(participant));
        }

        return null;
    }

}
