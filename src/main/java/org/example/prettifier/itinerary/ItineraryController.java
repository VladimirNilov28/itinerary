package org.example.prettifier.itinerary;

import org.example.prettifier.Prettifier;
import org.example.prettifier.itinerary.model.Itinerary;
import org.example.prettifier.itinerary.model.ItineraryDTO;
import org.example.prettifier.itinerary.model.Link;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class ItineraryController {

    private final Link link = new Link();

    public void fileReader() throws IOException {
        if(link.getINPUT_FILE().exists() || link.getINPUT_FILE().length() != 0) {
            try (BufferedReader br = new BufferedReader(new FileReader(link.getINPUT_FILE()))) {
                String line;


                while ((line = br.readLine()) != null) {
                    String airport_code = "";
                    String date_time = "";
                    String date_time_format = "";
                    String code_type = "";
                    for (int i = 0; i < line.length(); i++) {
                        if (line.charAt(i) == '#' || line.startsWith("*#", i)) {
                            code_type = (line.startsWith("*#", i)) ? "*IATA" : "IATA";
                            airport_code = (line.startsWith("*#", i)) ? line.substring(i + 1, 3) : line.substring(i, 3);
                            i += (line.startsWith("*#", i)) ? 5 : 4;
                        } else if (line.startsWith("##", i) || line.startsWith("*##", i)) {
                            code_type = (line.startsWith("*#", i)) ? "*ICAO" : "ICAO";
                            airport_code = (line.startsWith("*##", i)) ? line.substring(i + 2, 4 ) : line.substring(i + 1, 4);
                            i += (line.startsWith("*#", i)) ? 6 : 5;
                        } else if ()
                    }
                }
            }
        } else {
            //TODO обработка ошибки если отсутствует файл или пустой
        }
    }




    public void listParsing(List<String> inputList) throws IOException {

    }

    public void fileWriter() throws IOException {

    }
}
