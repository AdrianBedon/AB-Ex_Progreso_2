package com.rest_service.reservation.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rest_service.reservation.models.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long>{

}
