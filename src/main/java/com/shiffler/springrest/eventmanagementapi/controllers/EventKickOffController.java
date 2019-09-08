package com.shiffler.springrest.eventmanagementapi.controllers;

import com.shiffler.springrest.eventmanagementapi.entities.Event;
import com.shiffler.springrest.eventmanagementapi.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

//A Repository Rest Controller will use the base path in application.properties
@RepositoryRestController
@RequestMapping("/events")
public class EventKickOffController {

    private final EventRepository eventRepository;


    //Constructor Injection
    @Autowired
    public EventKickOffController(EventRepository eventRepository){
        this.eventRepository = eventRepository;

    }

    @PostMapping("/start/{id}")
    public ResponseEntity start(@PathVariable Long id){

        Optional<Event> optionalEvent = eventRepository.findById(id);
        Event event;

        if(optionalEvent.isPresent()){
            event = optionalEvent.get();
            event.setStarted(true);
            eventRepository.save(event);
        }else{
            throw new ResourceNotFoundException();
        }

        return ResponseEntity.ok(event.getName() + "has started");
    }

}
