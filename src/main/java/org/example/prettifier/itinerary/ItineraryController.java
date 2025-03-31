package org.example.prettifier.itinerary;

import org.example.prettifier.Prettifier;
import org.example.prettifier.itinerary.model.Itinerary;
import org.example.prettifier.itinerary.model.ItineraryDTO;
import org.example.prettifier.itinerary.model.Link;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class ItineraryController {

    private Link link = new Link();

    public void fileReader() throws IOException {
        List<String> inputList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(link.getINPUT_FILE()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                inputList.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        listParsing(inputList);

    }

    public void listParsing(List<String> inputList) {
        Itinerary itinerary = new Itinerary();

        for (String input : inputList) {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                String helper;
                if (c == 'T' && Character.isDigit(input.charAt(i + 1)) && Character.isDigit(input.charAt(i + 2))) {
                    helper = Character.toString(c) + input.charAt(i + 1) + input.charAt(i + 2);
                } else if (c == '#') {
                    helper = (input.charAt(i + 1) == '#') ? Character.toString(c) + input.charAt(i + 1) : Character.toString(c);
                } else {
                    helper = Character.toString(c);
                }
                switch (helper) {
                    case "D", "T12", "T24" -> {
                        StringBuilder date = new StringBuilder();
                        i = (helper.equals("D")) ? i + 1 : i + 3;
                        while (input.charAt(i) != ')') {
                            date.append(input.charAt(i));
                            i++;
                        }
                        itinerary.setDateTime(ZonedDateTime.parse(date.toString()));

                    }
                    case "#" -> ;
                    case "##" -> ;
                }

            }
            try {
                fileWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void fileWriter() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(link.getOUTPUT_FILE(), true))) {

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
