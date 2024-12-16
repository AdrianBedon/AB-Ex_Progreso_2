package com.microservice.room.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.room.models.Room;
import com.microservice.room.services.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Room room) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(room));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Room room, @PathVariable Long id) {
        Optional<Room> o = service.update(room, id);
        if (o.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(o.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    
}
