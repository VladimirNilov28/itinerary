package org.example.prettifier.itinerary.services;

import org.example.prettifier.common.ProgramMessages;
import org.example.prettifier.itinerary.model.Link;

import java.io.IOException;
import java.util.Scanner;

public class OutputService {
    public boolean ensureOutputFile(Link link) throws IOException {
        try(Scanner scanner = new Scanner(System.in)) {
            var output = link.getOUTPUT_FILE();
            if (!output.exists()) {
                System.out.print(ProgramMessages.CREATE_OUTPUT_FILE.toString());
                return scanner.nextLine().equals("y") && output.createNewFile();
            } else {
                System.out.print(ProgramMessages.OVERWRITE_OUTPUT_FILE.toString());
                return scanner.nextLine().equalsIgnoreCase("y");
            }
        }
    }
}
