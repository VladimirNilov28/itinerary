package org.example.prettifier.itinerary.validators;

public class ItineraryValidator {
    public void flagCheck (String[] args) {
        if (args == null || args.length == 0) {
            System.err.println("Please specify at least one argument");
        }
    }
}
