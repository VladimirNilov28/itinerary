package org.example.prettifier.itinerary.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AirportRawData {
    private String name;
    private String iso_country;
    private String municipality;
    private String icao_code;
    private String iata_code;
    private String coordinates;
}
