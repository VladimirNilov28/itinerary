package org.example.prettifier;

import org.example.prettifier.itinerary.ItineraryController;
import org.example.prettifier.itinerary.model.Link;

import java.io.File;
import java.io.IOException;

public class Prettifier {
    public static void main(String[] args) {
        ItineraryController controller = new ItineraryController();
        Link link = new Link();
        try{
            link.setINPUT_FILE(new File(args[0]));
            link.setOUTPUT_FILE(new File(args[1]));
            link.setAIRPORT_LOOKUP_FILE(new File(args[2]));
        }
        catch (Exception e) { //IOException handler
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        controller.fileReader();

    }
}
