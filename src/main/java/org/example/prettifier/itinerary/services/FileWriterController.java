package org.example.prettifier.itinerary.services;

import org.example.prettifier.common.enums.ErrorMessages;
import org.example.prettifier.common.enums.ProgramMessages;
import org.example.prettifier.itinerary.model.AirportsData;
import org.example.prettifier.itinerary.model.Itinerary;
import org.example.prettifier.itinerary.model.ItineraryDTO;
import org.example.prettifier.itinerary.model.ItineraryEntry;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

public class FileWriterController {

    public void fileWriterController(File file, Itinerary itinerary,
                                     AirportsData airportsData) throws IOException {
        List<ItineraryEntry> entries = itinerary.getEntries();
        CreateDTO dto = new CreateDTO(airportsData);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            int index = 0;
            for (ItineraryEntry entry : entries) {
                index++;
                ItineraryDTO currentDTO = dto.newDTO(entry);

                String airportName = currentDTO.getAirportName() != null ? currentDTO.getAirportName() : "";
                String municipality = currentDTO.getMunicipality() != null ? currentDTO.getMunicipality() : "";
                String t24 = currentDTO.getT24() != null ? currentDTO.getT24() : "";
                String t12 = currentDTO.getT12() != null ? currentDTO.getT12() : "";
                String date = currentDTO.getDate() != null ? currentDTO.getDate() : "";

                if (entry.is_city_need()) {
                    writer.write(airportName + " " + municipality);
                } else {
                    writer.write(airportName);
                }
                switch (entry.getDate_time_format()) {
                    case "T24" -> {
                        if (airportName.isEmpty()) {
                            writer.write(t24);
                        } else {
                            writer.write(" " + t24);
                        }
                    }
                    case "T12" -> {
                        if (airportName.isEmpty()) {
                            writer.write(t12);
                        } else {
                            writer.write(" " + t12);
                        }
                    }
                    case "D" -> {
                        if (airportName.isEmpty()) {
                            writer.write(date);
                        } else {
                            writer.write(" " + date);
                        }
                    }
                    default -> {
                        writer.write("");
                    }
                }

                writer.newLine();
            }
        }
        System.out.println(ProgramMessages.FILE_WRITE_OK.getMessage() + file.getAbsolutePath());
    }

    private boolean isValidDateTimeFormat(String dateTimeFormat) {
        try{
            ZonedDateTime.parse(dateTimeFormat);
            return true;
        }
        catch (DateTimeParseException e){
            return false;
        }
    }
}
