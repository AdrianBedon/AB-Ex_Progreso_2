package com.soap_availability.service.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soap_availability.service.models.Availability;
import com.soap_availability.service.repositories.AvailabilityRepository;

@Service
public class AvailabilityService {
    @Autowired
    private AvailabilityRepository repository;

    public List<Availability> getAvailability(String roomType, String status, LocalDate availableDate) {
        return repository.findByRoomTypeAndStatusAndAvailableDate(roomType, status, availableDate);
    }
}
