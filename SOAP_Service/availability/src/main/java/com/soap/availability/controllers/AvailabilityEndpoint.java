package com.soap.availability.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.availability.repositories.AvailabilityRepository;

import service.soap_availability.soap.Availability;
import service.soap_availability.soap.AvailabilityRequest;
import service.soap_availability.soap.AvailabilityResponse;

@Endpoint
public class AvailabilityEndpoint {
    private static final String NAMESPACE_URI = "http://soap_availability.service/soap";

    @Autowired
    private AvailabilityRepository repository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AvailabilityRequest")
    @ResponsePayload
    public AvailabilityResponse getAvailability(@RequestPayload AvailabilityRequest request) {
        LocalDate startDate = convertToLocalDate(request.getStartDate());
        LocalDate endDate = convertToLocalDate(request.getEndDate());

        // Use the converted LocalDate values in the repository query
        List<Availability> availableRooms = repository.findByRoomTypeAndAvailableDateBetweenAndStatus(
                request.getRoomType(),
                startDate,
                endDate,
                request.getStatus()
        );


        AvailabilityResponse response = new AvailabilityResponse();
        response.getAvailability().addAll(availableRooms);
        return response;
    }

    private LocalDate convertToLocalDate(XMLGregorianCalendar xmlGregorianCalendar) {
        if (xmlGregorianCalendar != null) {
            return xmlGregorianCalendar.toGregorianCalendar().toZonedDateTime().toLocalDate();
        }
        return null; // Return null if the XMLGregorianCalendar is null
    }
}
