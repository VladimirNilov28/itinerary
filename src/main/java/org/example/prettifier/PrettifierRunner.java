package org.example.prettifier;

import org.example.prettifier.common.ProgramMessages;
import org.example.prettifier.common.exceptions.AppExceptions;
import org.example.prettifier.itinerary.ItineraryService;
import org.example.prettifier.itinerary.model.AirportsData;
import org.example.prettifier.itinerary.model.Link;
import org.example.prettifier.itinerary.services.AirportLookupLoader;
import org.example.prettifier.itinerary.services.FileFormaterController;
import org.example.prettifier.itinerary.services.OutputService;
import org.example.prettifier.itinerary.validators.ItineraryValidator;

import java.io.IOException;

public class PrettifierRunner {
    public void run(String[] args) throws IOException {
        AirportsData airportsData = new AirportsData();
        AirportLookupLoader loader = new AirportLookupLoader(airportsData);
        Link link = new Link();
        ItineraryValidator validator = new ItineraryValidator();

        try {
            validator.flagCheck(args);
            link.setINPUT_FILE(args[0]);
            link.setOUTPUT_FILE(args[1]);
            link.setAIRPORT_LOOKUP_FILE(args[2]);
        } catch (AppExceptions e) {
            System.err.println(e.getMessage() + "\n" + ProgramMessages.CORRECT_PROGRAM_USAGE);
            System.exit(1);
        }

        if(!new OutputService().ensureOutputFile(link)) {
            System.out.println("Operation was cancelled.");
            System.exit(0);
        }

        try {
            loader.load(link.getAIRPORT_LOOKUP_FILE());
        } catch (AppExceptions e) {
            System.err.println(e.getMessage() + ": " + link.getAIRPORT_LOOKUP_FILE().getAbsolutePath());
            System.exit(1);
        }

        ItineraryService controller = new ItineraryService(link, new FileFormaterController(airportsData));

        try {
            controller.fileFormater();
        } catch (AppExceptions e) {
            System.err.println(e.getMessage() + "\n" + ProgramMessages.CORRECT_PROGRAM_USAGE);
            System.exit(1);
        }

        System.out.println(ProgramMessages.OPERATION_OK.toString() + " Result saved to: " + link.getOUTPUT_FILE().getAbsolutePath());

    }
}
