//package org.example.prettifier.itinerary.services;
//
//import org.example.prettifier.common.enums.ErrorMessages;
//import org.example.prettifier.itinerary.model.Itinerary;
//import org.example.prettifier.itinerary.model.ItineraryEntry;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.File;
//import java.io.IOException;
//import java.time.DateTimeException;
//import java.time.ZonedDateTime;
//import java.time.format.DateTimeParseException;
//
//public class FileReaderController {
//    public void fileReaderController(File file, Itinerary itinerary) throws IOException {
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            String line;
//            int lineNumber = 0;
//            while ((line = br.readLine()) != null) {
//                lineNumber++;
//                if (line.isEmpty()) continue;
//                String airport_code = "";
//                String date_time = "";
//                String date_time_format = "";
//                String code_type = "";
//                StringBuilder text = new StringBuilder();
//                boolean is_city_need = false;
//                for (int i = 0; i < line.length(); i++) {
//
//                    if (i + 1 < line.length() && line.charAt(i) == '#' && line.charAt(i + 1) != '#') {
//                        is_city_need = (line.charAt(i - 1) == '*');
//                        code_type = "IATA";
//                        airport_code = line.substring(i + 1, i + 4);
//                        i += 4;
//                    } else if (line.startsWith("##", i)) {
//                        is_city_need = (line.charAt(i - 1) == '*');
//                        code_type = "ICAO";
//                        airport_code = line.substring(i + 2, i + 6);
//                        i += 6;
//                    } else if (startsWithAny(line, i, "T24", "T12", "D") != null) {
//                        date_time_format = startsWithAny(line, i, "T24", "T12", "D");
//                        int start = line.indexOf('(', i);
//                        int end = line.indexOf(')', start);
//                        date_time = (start != -1 && end != -1 && start < end)
//                                ? line.substring(start + 1, end)
//                                : "";
//                        i = end;
//                    }
//                    else {
//                        text.append(line.charAt(i));
//                    }
//                }
////                System.out.printf("✅ Entry: code=%s | type=%s | city=%s | format=%s | date=%s%n",
////                        airport_code, code_type, is_city_need, date_time_format, date_time);
//                ItineraryEntry entry = new ItineraryEntry(airport_code, code_type, date_time, date_time_format, is_city_need);
//                itinerary.getEntries().add(entry);
//            }
//        }
//    }
//
//    private String startsWithAny(String line, int index, String... options) {
//        for (String prefix : options) {
//            if (line.startsWith(prefix, index)) {
//                return prefix;
//            }
//        }
//        return null;
//    }
//
//}
