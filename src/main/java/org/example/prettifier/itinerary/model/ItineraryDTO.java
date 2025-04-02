package org.example.prettifier.itinerary.model;

import lombok.Data;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Getter
public class ItineraryDTO extends Itinerary {
    private final AirportsData airportsData;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
    private Locale locale;

    private String airportName;
    private String country;
    private String municipality;
    private String date;
    private String T12;
    private String T24;

    //TODO Нужно сделать правильную генерацию DTO

    public ItineraryDTO() {

    }
}