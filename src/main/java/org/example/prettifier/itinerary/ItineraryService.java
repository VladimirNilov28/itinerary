package org.example.prettifier.itinerary;

import org.example.prettifier.common.exceptions.FileNotFound;
import org.example.prettifier.itinerary.model.*;
import org.example.prettifier.itinerary.services.FileFormaterController;

import java.io.*;

public class ItineraryService {

    private final Link link;
    private final FileFormaterController fileFormaterController;
    private final Stats stats;

    public ItineraryService(Link link, FileFormaterController fileFormaterController, Stats stats) {
        this.link = link;
        this.fileFormaterController = fileFormaterController;
        this.stats = stats;
    }

    public void fileFormater() throws IOException {
        if (link.getINPUT_FILE().exists() && link.getOUTPUT_FILE().exists()) {
            fileFormaterController.formater(link, stats);
        } else if (!link.getINPUT_FILE().exists()) {
            throw new FileNotFound(link.getINPUT_FILE().getName());
        } else {
            throw new FileNotFound(link.getOUTPUT_FILE().getName());
        }
    }

}
