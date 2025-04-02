package org.example.prettifier;

import org.example.prettifier.itinerary.services.AirportLookupLoader;
import org.example.prettifier.itinerary.model.AirportsData;
import org.example.prettifier.itinerary.model.Link;

import java.io.File;
import java.io.IOException;

public class Prettifier {
    public static void main(String[] args) throws IOException {
        Link link = new Link();
        AirportsData airportsData = new AirportsData();
        AirportLookupLoader loader = new AirportLookupLoader(airportsData);

        link.setINPUT_FILE(new File(args[0]));
        link.setOUTPUT_FILE(new File(args[1]));
        loader.load(new File(args[2]));

    }
}
