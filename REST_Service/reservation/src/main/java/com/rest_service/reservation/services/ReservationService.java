package com.rest_service.reservation.services;

import java.util.Optional;

import com.rest_service.reservation.models.Reservation;

public interface ReservationService {
    Optional<Reservation> findById(Long id);

    Reservation save(Reservation reservation);

    void remove(Long id);
}
