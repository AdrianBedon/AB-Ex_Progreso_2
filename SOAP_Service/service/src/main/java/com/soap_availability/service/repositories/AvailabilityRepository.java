package com.soap_availability.service.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soap_availability.service.models.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {
    List<Availability> findByRoomTypeAndStatusAndAvailableDate(String roomType, String status, LocalDate availableDate);
}
