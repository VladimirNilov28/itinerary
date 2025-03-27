package org.example.prettifier.itinerary.model;

import lombok.Data;
import java.time.ZonedDateTime;
import java.util.Locale;

@Data
public class ItineraryDTO {
    private String name;
    private String country;
    private String municipality;
    private String date;
    private String T12;
    private String T24;

    public ItineraryDTO(Itinerary itinerary) {
        this.name = itinerary.getName();
        this.municipality = itinerary.getMunicipality();
        this.country = isoToString();

        //this.dateTime = itinerary.getDateTime().get;
    }

    private static String isoToString(Itinerary itinerary) {
        Locale locale = new Locale("", itinerary.getIso());
        return locale.getDisplayCountry(locale);
    }
}
