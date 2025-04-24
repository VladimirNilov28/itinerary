package org.example.prettifier.itinerary.validators;

import org.example.prettifier.common.ProgramMessages;
import org.example.prettifier.common.exceptions.ArgsFormatException;
import org.example.prettifier.itinerary.services.VersionControl;

import java.io.IOException;

public class ItineraryValidator {

    public void flagCheck(String[] args) throws IOException {
        if (args.length == 0) {
            throw new ArgsFormatException();
        }
        if ("-h".equals(args[0])) {
            System.out.println(ProgramMessages.CORRECT_PROGRAM_USAGE);
            System.exit(0);
        }
        if ("--version".equals(args[0])) {
            System.out.println("Current version is: " + new VersionControl().getVersion());
            System.exit(0);
        }
        if (args.length < 3 || args[0].isBlank() || args[1].isBlank() || args[2].isBlank()) {
            throw new ArgsFormatException();
        }
    }
}
