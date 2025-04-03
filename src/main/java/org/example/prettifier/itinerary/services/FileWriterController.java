package org.example.prettifier.itinerary.services;

import org.example.prettifier.itinerary.model.AirportsData;
import org.example.prettifier.itinerary.model.Itinerary;
import org.example.prettifier.itinerary.model.ItineraryDTO;
import org.example.prettifier.itinerary.model.ItineraryEntry;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterController {
    public void fileWriterController(File file, Itinerary itinerary,
                                     AirportsData airportsData, ItineraryDTO itineraryDTO) throws IOException {
        List<ItineraryEntry> entries = itinerary.getEntries();
        CreateDTO dto = new CreateDTO(airportsData);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (ItineraryEntry entry : entries) {
                ItineraryDTO currentDTO = dto.newDTO(entry);
                if (entry.is_city_need()) {
                    String fullName = currentDTO.getAirportName();
                    if (currentDTO.getMunicipality() != null && !currentDTO.getMunicipality().isBlank()) {
                        fullName += " " + currentDTO.getMunicipality();
                    }
                    writer.write(fullName.trim()); // trim — на всякий случай
                } else {
                    writer.write(currentDTO.getAirportName());
                }
                switch (entry.getDate_time_format()) {
                    case "T24" -> writer.write(currentDTO.getT24());
                    case "T12" -> writer.write(currentDTO.getT12());
                    case "D" -> writer.write(currentDTO.getDate());
                }
            }
        }
    }
}
