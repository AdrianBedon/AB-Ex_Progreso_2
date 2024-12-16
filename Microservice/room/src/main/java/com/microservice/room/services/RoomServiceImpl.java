package com.microservice.room.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.room.models.Room;
import com.microservice.room.repositories.RoomRepository;

import jakarta.transaction.Transactional;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    @Transactional
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    @Transactional
    public Optional<Room> update(Room room, Long id) {
        Optional<Room> o = roomRepository.findById(id);
        Room roomOptional = null;
        if (o.isPresent()) {
            Room roomDb = o.orElseThrow();
            roomDb.setStatus(room.getStatus());
            roomOptional = roomRepository.save(roomDb);
        }
        return Optional.ofNullable(roomOptional);
    }
}
