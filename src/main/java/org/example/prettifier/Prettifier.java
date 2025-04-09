package org.example.prettifier;

import org.example.prettifier.common.enums.ProgramMessages;
import org.example.prettifier.common.exceptions.AppExceptions;
import org.example.prettifier.itinerary.ItineraryController;
import org.example.prettifier.itinerary.model.*;
import org.example.prettifier.itinerary.services.AirportLookupLoader;
import org.example.prettifier.itinerary.services.FileFormaterController;
import java.io.IOException;

public class Prettifier {

    public static void main(String[] args) throws IOException {
        AirportsData airportsData = new AirportsData();
        AirportLookupLoader loader = new AirportLookupLoader(airportsData);
        Link link = new Link();

        if (args.length == 0 || args[0].equals("-h")) {
            System.out.println(ProgramMessages.CORRECT_PROGRAM_USAGE.getMessage());
            System.exit(0);
        }

        try {
            link.setINPUT_FILE(args[0]);
            link.setOUTPUT_FILE(args[1]);
            link.setAIRPORT_LOOKUP_FILE(args[2]);
        } catch (AppExceptions e) {
            System.err.println(e.getMessage() + ProgramMessages.CORRECT_PROGRAM_USAGE.getMessage());
        }

        try {
            loader.load(link.getAIRPORT_LOOKUP_FILE());
        } catch (AppExceptions e) {
            System.err.println(e.getMessage() + ":" + link.getAIRPORT_LOOKUP_FILE().getAbsolutePath());
        }

        ItineraryController controller = new ItineraryController(link, new FileFormaterController(airportsData));
        controller.fileFormater();

    }
}

/*TODO нужно переделать логику считывания файла, в одной строке может быть больше одной даты так и кода.
Должно сохраняться изначальный текст
* */
