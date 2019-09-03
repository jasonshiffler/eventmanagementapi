package com.shiffler.springrest.eventmanagementapi.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="organizer")
public class Organizer extends AbstractEntity{

    private String name;

    //An organizer can have many events.
    @OneToMany(mappedBy = "organizer")
    private Set<Event> event;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Event> getEvents() {
        return event;
    }

    public void setEvents(Set<Event> events) {
        this.event = events;
    }

    //Exposing the id field so we can view it
    public Long getResourceId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organizer organizer = (Organizer) o;
        return id.equals(organizer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
