package com.soap.availability.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import service.soap_availability.soap.Availability;


public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    List<Availability> findByRoomTypeAndAvailableDateBetweenAndStatus(
            String roomType, LocalDate startDate, LocalDate endDate, String status);
}
