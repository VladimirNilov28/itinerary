package org.example.prettifier.itinerary;

import org.example.prettifier.itinerary.model.*;
import org.example.prettifier.itinerary.services.CreateDTO;
import org.example.prettifier.itinerary.services.FileReaderController;
import org.example.prettifier.itinerary.services.FileWriterController;

import java.io.*;
import java.util.List;

public class ItineraryController {

    private final ItineraryDTO itineraryDTO;
    private final Link link;
    private final Itinerary itinerary;
    private final AirportsData airportsData;
    private final FileWriterController fileWriterController;
    private final FileReaderController fileReaderController;

    public ItineraryController(ItineraryDTO itineraryDTO, Link link, Itinerary itinerary,
                               AirportsData airportsData, FileWriterController fileWriterController,
                               FileReaderController fileReaderController) {
        this.itineraryDTO = itineraryDTO;
        this.link = link;
        this.itinerary = itinerary;
        this.airportsData = airportsData;
        this.fileWriterController = fileWriterController;
        this.fileReaderController = fileReaderController;
    }


    public void fileReader() throws IOException {
        if(link.getINPUT_FILE().exists() || link.getINPUT_FILE().length() != 0) {
            fileReaderController.fileReaderController(link.getINPUT_FILE(), itinerary);
        } else {
            throw new FileNotFoundException("Input file not found or empty");
        }
    }

    public void fileWriter() throws IOException {
        if (link.getOUTPUT_FILE().exists()) {
            fileWriterController.fileWriterController(link.getOUTPUT_FILE(), itinerary, airportsData, itineraryDTO);
        } else {
            throw new FileNotFoundException("Output file not found");
        }
    }
}
