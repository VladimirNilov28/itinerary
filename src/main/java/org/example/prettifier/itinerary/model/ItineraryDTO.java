package org.example.prettifier.itinerary.model;

import lombok.Data;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
public class ItineraryDTO {
    private String airportName;
    private String country;
    private String municipality;
    private String date;
    private String T12;
    private String T24;

    public ItineraryDTO(Itinerary itinerary) {
        Locale locale = new Locale("", itinerary.getIso()); // from iso to full country name
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm (XXX)"); //pattern for T12 time

        this.airportName = itinerary.getAirportName();
        this.country = locale.getDisplayCountry(locale.ENGLISH);
        this.municipality = itinerary.getMunicipality();
        this.date = itinerary.getDateTime().toLocalDate().toString();
        this.T12 = itinerary.getDateTime().format(formatter);
        this.T24 = itinerary.getDateTime().toLocalTime().toString();
    }
}
