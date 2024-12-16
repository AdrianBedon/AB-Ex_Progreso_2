package com.microservice.room.repositories;

import org.springframework.data.repository.CrudRepository;

import com.microservice.room.models.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {

}
