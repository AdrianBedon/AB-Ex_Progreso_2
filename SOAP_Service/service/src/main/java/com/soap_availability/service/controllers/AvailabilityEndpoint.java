package com.soap_availability.service.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap_availability.service.models.Availability;
import com.soap_availability.service.repositories.AvailabilityRepository;

import jakarta.xml.bind.annotation.XmlRootElement;

@Endpoint
@Component
public class AvailabilityEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8082/soap_availability/service";

    @Autowired
    private AvailabilityRepository repository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AvailabilityRequest")
    @ResponsePayload
    public AvailabilityResponse getAvailability(@RequestPayload AvailabilityRequest request) {
        List<Availability> availableRooms = repository.findByRoomTypeAndStatusAndAvailableDate(
                request.getRoomType(),request.getStatus(), request.getAvailableDate());

        AvailabilityResponse response = new AvailabilityResponse();
        response.setRooms(availableRooms);
        return response;
    }
}

@XmlRootElement(name = "AvailabilityRequest")
class AvailabilityRequest {
    private LocalDate availableDate;
    private String status;
    private String roomType;
    public LocalDate getAvailableDate() {
        return availableDate;
    }
    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getRoomType() {
        return roomType;
    }
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}

@XmlRootElement(name = "AvailabilityResponse")
class AvailabilityResponse {
    private List<Availability> rooms;

    public List<Availability> getRooms() {
        return rooms;
    }

    public void setRooms(List<Availability> rooms) {
        this.rooms = rooms;
    }
}