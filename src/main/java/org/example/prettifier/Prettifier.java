package org.example.prettifier;

import org.example.prettifier.itinerary.ItineraryController;
import org.example.prettifier.itinerary.controller.AirportLookupLoader;
import org.example.prettifier.itinerary.model.AirportsData;
import org.example.prettifier.itinerary.model.Link;

import java.io.File;
import java.io.IOException;

public class Prettifier {
    public static void main(String[] args) {
//        Link link = new Link();
//        link.setINPUT_FILE(new File(args[0]));
//        link.setOUTPUT_FILE(new File(args[1]));

        AirportsData airportsData = new AirportsData();
        AirportLookupLoader loader = new AirportLookupLoader(airportsData);
        try {
            loader.load(new File("src/main/resources/airport-lookup.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int count = 0;
        for (var entry : airportsData.getLookup().entrySet()) {
            if (++count > 10) break;
            System.out.println(entry);
        }


    }
}
