package org.example.prettifier;

import org.example.prettifier.itinerary.ItineraryController;
import org.example.prettifier.itinerary.model.*;
import org.example.prettifier.itinerary.services.AirportLookupLoader;
import org.example.prettifier.itinerary.services.FileReaderController;
import org.example.prettifier.itinerary.services.FileWriterController;

import java.io.File;
import java.io.IOException;

public class Prettifier {

    public static void main(String[] args) throws IOException {
        Link link = new Link();
        Itinerary itinerary = new Itinerary();
        AirportsData airportsData = new AirportsData();
        FileWriterController fileWriterController = new FileWriterController();
        FileReaderController fileReaderController = new FileReaderController();


        AirportLookupLoader loader = new AirportLookupLoader(airportsData);
        ItineraryController controller = new ItineraryController(
                link, itinerary, airportsData, fileWriterController, fileReaderController);

        link.setINPUT_FILE(new File(args[0]));
        link.setOUTPUT_FILE(new File(args[1]));
        loader.load(new File(args[2]));
        controller.fileReader();
        controller.fileWriter();

    }
}
