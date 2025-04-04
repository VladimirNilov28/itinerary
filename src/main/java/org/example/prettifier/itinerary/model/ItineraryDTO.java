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
        AirportRawData airport = airportsData.getLookup().get(itineraryEntry.getAirport_code());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        DateTimeFormatter t12Formatter = DateTimeFormatter.ofPattern("hh:mma (XXX)", Locale.ENGLISH);
        DateTimeFormatter t24Formatter = DateTimeFormatter.ofPattern("HH:mm (XXX)", Locale.ENGLISH);

        this.airportName = (airport != null && airport.getName() != null) ? airport.getName() : "";
        this.country = (airport != null && airport.getIso_country() != null)
                ? Locale.of("", airport.getIso_country()).getDisplayCountry(Locale.ENGLISH)
                : "";
        this.municipality = (airport != null && airport.getMunicipality() != null) ? airport.getMunicipality() : "";

        ZonedDateTime dt = itineraryEntry.getDate_time();
        this.date = dt != null ? dt.format(dateTimeFormatter) : "";
        this.T12 = dt != null ? dt.format(t12Formatter) : "";
        this.T24 = dt != null ? dt.format(t24Formatter) : "";
    }
}