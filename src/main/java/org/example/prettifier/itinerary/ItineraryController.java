package org.example.prettifier.itinerary;

import org.example.prettifier.common.enums.ErrorMessages;
import org.example.prettifier.common.enums.ProgramMessages;
import org.example.prettifier.itinerary.model.*;
import java.io.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;

public class ItineraryController {

    //private final ItineraryDTO itineraryDTO;
    private final Link link;
    //private final Itinerary itinerary;
    private final AirportsData airportsData;
    //private final FileWriterController fileWriterController;
    //private final FileReaderController fileReaderController;

    public ItineraryController(Link link,
                               AirportsData airportsData) {
        //this.itineraryDTO = itineraryDTO;
        this.link = link;
        //this.itinerary = itinerary;
        this.airportsData = airportsData;
        //this.fileWriterController = fileWriterController;
        //this.fileReaderController = fileReaderController;
    }


//    public void fileReader() throws IOException {
//        if(link.getINPUT_FILE().exists()) {
//            if(link.getINPUT_FILE().length() == 0){
//                System.err.println(ErrorMessages.INPUT_FILE_EMPTY);
//                System.exit(1);
//            }
//            fileReaderController.fileReaderController(link.getINPUT_FILE(), itinerary);
//        } else {
//            throw new FileNotFoundException(ErrorMessages.INPUT_FILE_NOT_FOUND.getMessage());
//        }
//    }

//    public void fileWriter() throws IOException {
//        if (link.getOUTPUT_FILE().exists()) {
//            fileWriterController.fileWriterController(link.getOUTPUT_FILE(), itinerary, airportsData);
//        } else {
//            throw new FileNotFoundException(ErrorMessages.OUTPUT_FILE_NOT_FOUND.getMessage());
//        }
//    }

    public void fileFormater() throws IOException {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        DateTimeFormatter t12Formatter = DateTimeFormatter.ofPattern("hh:mma (XXX)", Locale.ENGLISH);
        DateTimeFormatter t24Formatter = DateTimeFormatter.ofPattern("HH:mm (XXX)", Locale.ENGLISH);
        if (link.getINPUT_FILE().exists() && link.getOUTPUT_FILE().exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(link.getINPUT_FILE()));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(link.getOUTPUT_FILE()))) {
                String line;
                int line_num = 0;
                boolean is_city_need = false;
                while ((line = reader.readLine()) != null) {
                    line_num++;
                    for (int i = 0; i < line.length(); i++) {
                        if (i + 1 < line.length() && line.charAt(i) == '#' && line.charAt(i + 1) != '#') {
                            is_city_need = (line.charAt(i - 1) == '*');
                            //code_type = "IATA";
                            String airport_code = line.substring(i + 1, i + 4);
                            writer.write(isCityNeed(airport_code, is_city_need));
                            i += 4;
                        } else if (line.startsWith("##", i)) {
                            is_city_need = (line.charAt(i - 1) == '*');
                            //code_type = "ICAO";
                            String airport_code = line.substring(i + 2, i + 6);
                            writer.write(isCityNeed(airport_code, is_city_need));
                            i += 6;
                        } else if (startsWithAny(line, i, "T24", "T12", "D") != null) {
                            String date_time_format = startsWithAny(line, i, "T24", "T12", "D");
                            int start = line.indexOf('(', i);
                            int end = line.indexOf(')', start);
                            try {
                                ZonedDateTime date_time = (start != -1 && end != -1 && start < end)
                                        ? ZonedDateTime.parse(line.substring(start + 1, end))
                                        : null;
                                switch (date_time_format) {
                                    case "T24" -> writer.write(date_time.format(t24Formatter));
                                    case "T12" -> writer.write(date_time.format(t12Formatter));
                                    case "D" -> writer.write(date_time.format(dateFormatter));
                                    default -> writer.write("");
                                }
                            } catch (DateTimeParseException e) {
                                System.err.println(ProgramMessages.FILE_WRITE_WARN.getMessage() + "at line: " + line_num);
                                writer.write(date_time_format + "(" + line.substring(start + 1, end) + ")");
                            }
                            i = end;
                        }
                        else {
                            writer.write(Character.toString(line.charAt(i)));
                        }
                    }
                    writer.newLine();
                }
            }
        } else if (!link.getOUTPUT_FILE().exists()) {
            throw new FileNotFoundException(ErrorMessages.OUTPUT_FILE_NOT_FOUND.getMessage());
        } else {
            throw new FileNotFoundException(ErrorMessages.INPUT_FILE_NOT_FOUND.getMessage());
        }
    }
    private String isCityNeed (String airport_code, boolean is_city_need) {
        return (is_city_need)
                ? Locale.of("", airportsData.getLookup().get(airport_code).getIso_country()).getDisplayCountry(Locale.ENGLISH)
                : airportsData.getLookup().get(airport_code).getName();
    }

    private String startsWithAny(String line, int index, String... options) {
        for (String prefix : options) {
            if (line.startsWith(prefix, index)) {
                return prefix;
            }
        }
        return null;
    }
}
