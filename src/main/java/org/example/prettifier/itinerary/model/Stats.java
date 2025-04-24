package org.example.prettifier.itinerary.model;

import lombok.Getter;

@Getter
public class Stats {
    int lines;
    int airports_resolved;
    int dates_reformatted;

    public void appendLines(int value) {
        this.lines += value;
    }

    public void appendAirportsResolved(int value) {
        this.airports_resolved += value;
    }

    public void appendDatesReformatted(int value) {
        this.dates_reformatted += value;
    }
}
