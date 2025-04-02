package org.example.prettifier.itinerary.model;

import lombok.Data;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Getter
public class ItineraryDTO {
    private String airportName;
    private String country;
    private String municipality; //city
    private String date;
    private String T12;
    private String T24;

    public ItineraryDTO(ItineraryEntry itineraryEntry, AirportsData airportsData) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        DateTimeFormatter t12Formatter = DateTimeFormatter.ofPattern("hh:mma (XXX)", Locale.ENGLISH);
        DateTimeFormatter t24Formatter = DateTimeFormatter.ofPattern("HH:mm (XXX)", Locale.ENGLISH);
        this.airportName = airportsData.getLookup().get(itineraryEntry.getAirport_code()).getName();
        this.country = Locale.of("", airportsData.getLookup().get(itineraryEntry.getAirport_code()).getIso_country()).getDisplayCountry(Locale.ENGLISH);
        this.municipality = airportsData.getLookup().get(itineraryEntry.getAirport_code()).getMunicipality();
        this.date = itineraryEntry.getDate_time().format(dateTimeFormatter);
        this.T12 = itineraryEntry.getDate_time().format(t12Formatter);
        this.T24 = itineraryEntry.getDate_time().format(t24Formatter);
    }
}