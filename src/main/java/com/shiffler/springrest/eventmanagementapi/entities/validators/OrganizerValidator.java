package com.shiffler.springrest.eventmanagementapi.entities.validators;

import com.shiffler.springrest.eventmanagementapi.entities.Organizer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//This class is used to validate our Organizer before its created
//https://docs.spring.io/spring/docs/4.1.x/spring-framework-reference/html/validation.html

@Component("beforeCreateOrganizerValidator")
public class OrganizerValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Organizer.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Organizer organizer = (Organizer) o;
        if(organizer.getName().length() < 3){
            errors.reject("name","must be three characters or greater");
        } else if (organizer.getName().length() > 50){
            errors.reject("name","must be 50 characters or less");
        }

    }
}
