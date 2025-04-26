package org.example.prettifier.itinerary.services;

import org.example.prettifier.itinerary.model.AirportsData;
import org.example.prettifier.itinerary.model.Link;
import org.example.prettifier.itinerary.model.Stats;

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

    public void formater(Link link, Stats stats) throws IOException {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
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
                stats.appendLines(1);

                if (line.trim().isEmpty()) {
                    empty_line++;
                    if (empty_line > 1) {
                        continue; // пропускаем лишнюю пустую строку
                    }
                } else {
                    empty_line = 0;
                }

                // Заменяем \v, \f, \r на реальные переводы строки
                line = line
                        .replace("\\v", "\n")
                        .replace("\\f", "\n")
                        .replace("\\r", "\n")
                        .replaceAll("([ ]*\n[ ]*){2,}", "\n\n");

                // Разбиваем строку по \n
                String[] sublines = line.split("\n", -1);

                for (String subline : sublines) {
                    subline = subline.strip();
                    for (int i = 0; i < subline.length(); i++) {
                        if (i + 1 < subline.length() && subline.charAt(i) == '#' && subline.charAt(i + 1) != '#') {
                            is_city_need = (i > 0 && subline.charAt(i - 1) == '*');
                            if (i + 4 <= subline.length()) {
                                String airport_code = subline.substring(i + 1, i + 4);
                                writer.write(isCityNeed(airport_code, is_city_need));
                                i += 4;
                                stats.appendAirportsResolved(1);
                            }
                        } else if (subline.startsWith("##", i)) {
                            is_city_need = (i > 0 && subline.charAt(i - 1) == '*');
                            if (i + 6 <= subline.length()) {
                                String airport_code = subline.substring(i + 2, i + 6);
                                writer.write(isCityNeed(airport_code, is_city_need));
                                i += 6;
                                stats.appendAirportsResolved(1);
                            }
                        } else if (startsWithAny(subline, i, "T24", "T12", "D") != null) {
                            String date_time_format = startsWithAny(subline, i, "T24", "T12", "D");
                            int start = subline.indexOf('(', i);
                            int end = subline.indexOf(')', start);
                            try {
                                ZonedDateTime date_time = (start != -1 && end != -1 && start < end)
                                        ? ZonedDateTime.parse(subline.substring(start + 1, end))
                                        : null;
                                switch (date_time_format) {
                                    case "T24" -> writer.write(date_time.format(t24Formatter).replace("Z", "+00:00"));
                                    case "T12" -> writer.write(date_time.format(t12Formatter).replace("Z", "+00:00"));
                                    case "D" -> writer.write(date_time.format(dateFormatter));
                                    default -> writer.write("");
                                }
                            } catch (DateTimeParseException e) {
                                writer.write(date_time_format + "(" + subline.substring(start + 1, end) + ")");
                            }
                            i = end;
                            stats.appendDatesReformatted(1);
                        } else {
                            if (subline.charAt(i) == '*' && i + 1 < subline.length() && subline.charAt(i + 1) == '#') continue;
                            writer.write(Character.toString(subline.charAt(i)));
                        }
                    }
                    writer.newLine(); // Перенос строки после каждой подстроки
                }
            }
        }
    }


    private String isCityNeed (String airport_code, boolean is_city_need) {
        return (is_city_need)
                ? airportsData.getLookup().get(airport_code).getMunicipality()
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
