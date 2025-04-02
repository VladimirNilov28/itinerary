package org.example.prettifier.itinerary.services;

import org.example.prettifier.itinerary.model.AirportsData;
import org.example.prettifier.itinerary.model.ItineraryDTO;
import org.example.prettifier.itinerary.model.ItineraryEntry;

public class CreateDTO {
    private final AirportsData airportsData;

    public CreateDTO(AirportsData airportsData) {
        this.airportsData = airportsData;
    }

    public ItineraryDTO createDTO(ItineraryEntry itineraryEntry) {
       return new ItineraryDTO(itineraryEntry, airportsData);
    }
}
