//package org.example.prettifier.itinerary.model;
//
//import lombok.Data;
//import lombok.Getter;
//import org.example.prettifier.common.enums.ProgramMessages;
//
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;
//import java.util.Locale;
//
//@Getter
//public class ItineraryDTO {
//    private String airportName;
//    private String country;
//    private String municipality; //city
//    private String date;
//    private String T12;
//    private String T24;
//
//    public ItineraryDTO(ItineraryEntry itineraryEntry, AirportsData airportsData) {
//        AirportRawData airport = airportsData.getLookup().get(itineraryEntry.getAirport_code());
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
//        DateTimeFormatter t12Formatter = DateTimeFormatter.ofPattern("hh:mma (XXX)", Locale.ENGLISH);
//        DateTimeFormatter t24Formatter = DateTimeFormatter.ofPattern("HH:mm (XXX)", Locale.ENGLISH);
//
//        this.airportName = (airport != null && airport.getName() != null) ? airport.getName() : "";
//        this.country = (airport != null && airport.getIso_country() != null)
//                ? Locale.of("", airport.getIso_country()).getDisplayCountry(Locale.ENGLISH)
//                : "";
//        this.municipality = (airport != null && airport.getMunicipality() != null) ? airport.getMunicipality() : "";
//
//        try {
//            ZonedDateTime dt = ZonedDateTime.parse(itineraryEntry.getDate_time());
//            this.date = dt.format(dateTimeFormatter);
//            this.T12 = dt.format(t12Formatter);
//            this.T24 = dt.format(t24Formatter);
//        } catch (DateTimeParseException e) {
//            this.date = itineraryEntry.getDate_time();
//            this.T12 = itineraryEntry.getDate_time();
//            this.T24 = itineraryEntry.getDate_time();
//        }
//
//    }
//}