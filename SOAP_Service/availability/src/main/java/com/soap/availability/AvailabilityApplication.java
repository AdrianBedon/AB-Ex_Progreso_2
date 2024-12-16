package com.soap.availability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("service.soap_availability.soap")
public class AvailabilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvailabilityApplication.class, args);
	}

}
