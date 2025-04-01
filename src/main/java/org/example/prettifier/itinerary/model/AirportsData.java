package org.example.prettifier.itinerary.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


//обёртка для AirportRawData
@Data
public class AirportsData {
    private Map<String, AirportRawData> lookup = new HashMap<>();
}
