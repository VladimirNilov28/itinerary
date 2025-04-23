package org.example.prettifier.itinerary.validators;

import org.example.prettifier.common.ProgramMessages;
import org.example.prettifier.common.exceptions.ArgsFormatException;

public class ItineraryValidator {

    public void flagCheck(String[] args) {
        if (args.length == 0) {
            throw new ArgsFormatException();
        }
        if ("-h".equals(args[0])) {
            System.out.println(ProgramMessages.CORRECT_PROGRAM_USAGE);
            System.exit(0);
        }
        if (args.length < 3 || args[0].isBlank() || args[1].isBlank() || args[2].isBlank()) {
            throw new ArgsFormatException();
        }
    }
}
