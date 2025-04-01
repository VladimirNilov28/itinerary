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

    }

    //public Map<String, >


    public void listParsing(List<String> inputList) throws IOException {

    }

    public void fileWriter() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(link.getOUTPUT_FILE()));
             BufferedReader lookup_reader = new BufferedReader(new FileReader(link.getINPUT_FILE()))) {
            //String builder
        }
    }
}
