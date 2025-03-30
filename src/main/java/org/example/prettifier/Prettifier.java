package org.example.prettifier;

import org.example.prettifier.itinerary.ItineraryController;

import java.io.File;
import java.io.IOException;

public class Prettifier {
    public static void main(String[] args) {
        ItineraryController controller = new ItineraryController();
        try{
            controller.fileWriter(new File(args[0]));
            controller.fileReader(new File(args[1]));
        }
        catch (Exception e) { //IOException handler
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
