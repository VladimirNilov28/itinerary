package org.example.prettifier;

import org.example.prettifier.common.ProgramMessages;
import org.example.prettifier.common.exceptions.AppExceptions;
import org.example.prettifier.itinerary.ItineraryController;
import org.example.prettifier.itinerary.model.*;
import org.example.prettifier.itinerary.services.AirportLookupLoader;
import org.example.prettifier.itinerary.services.FileFormaterController;
import org.example.prettifier.itinerary.validators.ItineraryValidator;

import java.io.IOException;

public class Prettifier {

    public static void main(String[] args) throws IOException {
        AirportsData airportsData = new AirportsData();
        AirportLookupLoader loader = new AirportLookupLoader(airportsData);
        Link link = new Link();
        ItineraryValidator validator = new ItineraryValidator();

        validator.flagCheck(args);

        try {
            link.setINPUT_FILE(args[0]);
            link.setOUTPUT_FILE(args[1]);
            link.setAIRPORT_LOOKUP_FILE(args[2]);
        } catch (AppExceptions e) {
            System.err.println(e.getMessage() + "\n" + ProgramMessages.CORRECT_PROGRAM_USAGE);
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

//TODO Убрать лишние пропуски при создании output доделать перехват ошибок
