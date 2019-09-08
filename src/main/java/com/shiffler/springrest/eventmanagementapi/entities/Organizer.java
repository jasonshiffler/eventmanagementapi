package com.shiffler.springrest.eventmanagementapi.entities;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="organizer")
@Data
public class Organizer extends AbstractEntity{

    @NotNull
    private String name;

    //An organizer can have many events.
    @OneToMany(mappedBy = "organizer")
    private Set<Event> event;

    //Exposing the id field so we can view it
    public Long getResourceId(){
        return id;
    }

}