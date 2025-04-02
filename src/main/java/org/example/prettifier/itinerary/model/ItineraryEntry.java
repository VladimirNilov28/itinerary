package org.example.prettifier.itinerary.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class ItineraryEntry {
    private String airport_code; //хранит сам код
    private String code_type; //хранит тип кода IATA или ICAO
    private ZonedDateTime date_time; // хранит время и дату
    private String date_time_format; // хранит формат даты и времени например D, T12, T24
    private boolean is_city_need;
}
