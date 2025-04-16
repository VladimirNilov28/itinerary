package org.example.prettifier.itinerary.services;

import org.example.prettifier.itinerary.model.AirportsData;
import org.example.prettifier.itinerary.model.Link;

import java.io.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class FileFormaterController {

    private final AirportsData airportsData;

    public FileFormaterController(AirportsData airportsData) {
        this.airportsData = airportsData;
    }

    public void formater(Link link) throws IOException {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        DateTimeFormatter t12Formatter = DateTimeFormatter.ofPattern("hh:mma (XXX)", Locale.ENGLISH);
        DateTimeFormatter t24Formatter = DateTimeFormatter.ofPattern("HH:mm (XXX)", Locale.ENGLISH);
        try (BufferedReader reader = new BufferedReader(new FileReader(link.getINPUT_FILE()));
             BufferedWriter writer = new BufferedWriter(new FileWriter(link.getOUTPUT_FILE()))) {
            String line;
            int line_num = 0;
            int empty_line = 0;
            boolean is_city_need = false;
            while ((line = reader.readLine()) != null) {
                line_num++;
                if (line.trim().isEmpty()) {
                    empty_line++;
                    if (empty_line > 1) {
                        continue; // пропускаем лишнюю пустую строку
                    }
                } else {
                    empty_line = 0; // сброс, когда встретили непустую строку
                }
                line = line.replaceAll("\\s+", " ").trim();
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
                            switch (String.valueOf(date_time_format)) {
                                case "T24" -> writer.write(date_time.format(t24Formatter));
                                case "T12" -> writer.write(date_time.format(t12Formatter));
                                case "D" -> writer.write(date_time.format(dateFormatter));
                                default -> writer.write("");
                            }
                        } catch (DateTimeParseException e) {
                            writer.write(date_time_format + "(" + line.substring(start + 1, end) + ")");
                        }
                        i = end;
                    } else {
                        writer.write(Character.toString(line.charAt(i)));
                    }
                }

                writer.newLine();
            }
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
