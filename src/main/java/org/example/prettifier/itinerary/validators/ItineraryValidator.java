package org.example.prettifier.itinerary.validators;

import org.example.prettifier.common.ProgramMessages;
import org.example.prettifier.common.exceptions.ArgsFormatException;

public class ItineraryValidator {

    public void flagCheck(String[] args) {
        if (args.length == 0) {
            throw new ArgsFormatException(ProgramMessages.CORRECT_PROGRAM_USAGE);
        }

        if ("-h".equals(args[0])) {
            System.out.println(ProgramMessages.CORRECT_PROGRAM_USAGE);
            System.exit(0);
        }
    }
}
