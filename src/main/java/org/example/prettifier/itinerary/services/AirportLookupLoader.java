package org.example.prettifier.itinerary.services;

import org.example.prettifier.common.enums.ErrorMessages;
import org.example.prettifier.itinerary.model.AirportRawData;
import org.example.prettifier.itinerary.model.AirportsData;

import java.io.*;
import java.nio.charset.MalformedInputException;

public class AirportLookupLoader {

    private final AirportsData airportsData;

    public AirportLookupLoader(AirportsData airportsData) {
        this.airportsData = airportsData;
    }

    public void load(File file) throws IOException {
        int line_number = 0;
        if (file.exists() || file.length() != 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    line_number++;
                    if (line_number == 1 || line.startsWith("name,")) continue;

                    if (line.isBlank()) {
                        throw new IllegalStateException(ErrorMessages.AIRPORT_LOOKUP_MALFORMED.getMessage());
                    }

                    String[] parts = line.split(",", -1);

                    if (parts.length < 7) {
                        throw new IllegalStateException(ErrorMessages.AIRPORT_LOOKUP_MALFORMED.getMessage());
                    }

                    for (String part : parts) {
                        if (part.isBlank()) {
                            throw new IllegalStateException(ErrorMessages.AIRPORT_LOOKUP_MALFORMED.getMessage());
                        }
                    }
                    String name = parts[0];
                    String iso_country = parts[1];
                    String municipality = parts[2];
                    String icao_code = parts[3];
                    String iata_code = parts[4];
                    String coordinates = (parts[5].trim() + ", " + parts[6].trim()).replace("\"", "");
                    AirportRawData airportRawData = new AirportRawData(name, iso_country, municipality, icao_code, iata_code, coordinates);

                    if (!icao_code.isEmpty()) airportsData.getLookup().put(icao_code, airportRawData);
                    if (!iata_code.isEmpty()) airportsData.getLookup().put(iata_code, airportRawData);
                }
            }
        } else {
            throw new FileNotFoundException(ErrorMessages.AIRPORT_LOOKUP_NOT_FOUND.getMessage());
        }

    }
}
