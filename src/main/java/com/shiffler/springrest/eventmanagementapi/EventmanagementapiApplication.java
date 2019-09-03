package com.shiffler.springrest.eventmanagementapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;

@SpringBootApplication
//Look at the JSR310 classes when scanning as well as our own.
@EntityScan(basePackageClasses = {EventmanagementapiApplication.class, Jsr310Converters.class})
public class EventmanagementapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventmanagementapiApplication.class, args);
	}

}
