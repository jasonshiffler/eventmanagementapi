package com.shiffler.springrest.eventmanagementapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.Instant;

//Using lombok to generate all of our getters,setters,equals,hashcode,toString
@Data
//This class is used by Entities
@MappedSuperclass
public abstract class AbstractEntity{

    @Id
    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    //Keeps this field from showing up in JSON data
    @JsonIgnore
    @CreationTimestamp
    @Column(updatable = false)
    protected Instant created;

}