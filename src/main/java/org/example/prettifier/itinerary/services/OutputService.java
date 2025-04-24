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
                while (true) {
                    System.out.print(ProgramMessages.CREATE_OUTPUT_FILE.toString());
                    String input = scanner.nextLine();
                    if (input.equals("y")) {
                        return output.createNewFile();
                    } else if (input.equals("n")) {
                        return false;
                    }
                }
            } else {
                while (true) {
                    System.out.print(ProgramMessages.OVERWRITE_OUTPUT_FILE.toString());
                    String input = scanner.nextLine();
                    if (input.equals("y")) {
                        return true;
                    } else if (input.equals("n")) {
                        return false;
                    }
                }

            }
        }
    }
}
