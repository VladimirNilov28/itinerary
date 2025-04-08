package org.example.prettifier;

import org.example.prettifier.itinerary.ItineraryController;
import org.example.prettifier.itinerary.model.*;
import org.example.prettifier.itinerary.services.AirportLookupLoader;
//import org.example.prettifier.itinerary.services.FileReaderController;
//import org.example.prettifier.itinerary.services.FileWriterController;

import java.io.File;
import java.io.IOException;

public class Prettifier {

    public static void main(String[] args) throws IOException {
        Link link = new Link();
        link.setINPUT_FILE(new File(args[0]));
        link.setOUTPUT_FILE(new File(args[1]));

        AirportsData airportsData = new AirportsData();
        AirportLookupLoader loader = new AirportLookupLoader(airportsData);
        loader.load(new File(args[2]));

        ItineraryController controller = new ItineraryController(link, airportsData);
        controller.fileFormater();

    }
}

/*TODO нужно переделать логику считывания файла, в одной строке может быть больше одной даты так и кода.
Должно сохраняться изначальный текст
* */
