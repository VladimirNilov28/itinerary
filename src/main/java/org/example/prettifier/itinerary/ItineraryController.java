package org.example.prettifier.itinerary;

import org.example.prettifier.common.exceptions.FileNotFound;
import org.example.prettifier.itinerary.model.*;
import org.example.prettifier.itinerary.services.FileFormaterController;

import java.io.*;

public class ItineraryController {

    private final Link link;
    private final FileFormaterController fileFormaterController;

    public ItineraryController(Link link, FileFormaterController fileFormaterController) {
        this.link = link;
        this.fileFormaterController = fileFormaterController;
    }

    public void fileFormater() throws IOException {
        if (link.getINPUT_FILE().exists() && link.getOUTPUT_FILE().exists()) {
            fileFormaterController.formater(link);
        } else if (!link.getINPUT_FILE().exists()) {
            throw new FileNotFound(link.getINPUT_FILE().getName());
        } else {
            throw new FileNotFound(link.getOUTPUT_FILE().getName());
        }
    }

}
