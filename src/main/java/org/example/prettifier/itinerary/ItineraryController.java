package org.example.prettifier.itinerary;

import org.example.prettifier.Prettifier;
import org.example.prettifier.itinerary.model.Itinerary;
import org.example.prettifier.itinerary.model.ItineraryDTO;
import org.example.prettifier.itinerary.model.ItineraryEntry;
import org.example.prettifier.itinerary.model.Link;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class ItineraryController {

    private final Link link = new Link();
    Itinerary itinerary = new Itinerary();

    public void fileReader() throws IOException {
        if(link.getINPUT_FILE().exists() || link.getINPUT_FILE().length() != 0) {
            try (BufferedReader br = new BufferedReader(new FileReader(link.getINPUT_FILE()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String airport_code = "";
                    ZonedDateTime date_time = null;
                    String date_time_format = "";
                    String code_type = "";
                    boolean is_city_need = false;
                    for (int i = 0; i < line.length(); i++) {
                        if (i + 1 < line.length() && line.charAt(i) == '#' && line.charAt(i + 1) != '#') {
                            is_city_need = (line.charAt(i - 1) == '*');
                            code_type = "IATA";
                            airport_code = line.substring(i, i + 3);
                            i += 4;
                        } else if (line.startsWith("##", i)) {
                            is_city_need = (line.charAt(i - 1) == '*');
                            code_type = "ICAO";
                            airport_code = line.substring(i + 1, i + 4);
                            i += 5;
                        } else if (line.startsWith("T24", i)) {
                            date_time_format = "T24";
                            int start = line.indexOf('(', i);
                            int end = line.indexOf(')', start);
                            date_time = (start != -1 && end != -1 && start < end) ? ZonedDateTime.parse(line.substring(start + 1, end)) : null;
                            i = end;
                        } else if (line.startsWith("T12", i)) {
                            date_time_format = "T12";
                            int start = line.indexOf('(', i);
                            int end = line.indexOf(')', start);
                            date_time = (start != -1 && end != -1 && start < end) ? ZonedDateTime.parse(line.substring(start + 1, end)) : null;
                            i = end;
                        } else if (line.startsWith("D", i)) {
                            date_time_format = "D";
                            int start = line.indexOf('(', i);
                            int end = line.indexOf(')', start);
                            date_time = (start != -1 && end != -1 && start < end) ? ZonedDateTime.parse(line.substring(start + 1, end)) : null;
                            i = end;
                        }
                    }
                    ItineraryEntry entry = new ItineraryEntry(airport_code, code_type, date_time, date_time_format, is_city_need);
                    itinerary.getEntries().add(entry);
                }
            }
        } else {
            //TODO обработка ошибки если отсутствует файл или пустой
        }
    }

    public void fileWriter() throws IOException {

    }
}
