package com.microservice.room.services;

import java.util.Optional;

import com.microservice.room.models.Room;

public interface RoomService {
    Room save(Room room);

    Optional<Room> update(Room room, Long id);
}
