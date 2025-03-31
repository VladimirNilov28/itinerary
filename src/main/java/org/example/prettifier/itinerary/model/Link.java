package org.example.prettifier.itinerary.model;

import lombok.Data;
import lombok.Getter;

import java.io.File;

@Getter
public class Link {
    private File INPUT_FILE;
    private File OUTPUT_FILE;
    private File AIRPORT_LOOKUP_FILE;

    public void setINPUT_FILE(File INPUT_FILE) {
        if(INPUT_FILE != null) {
            this.INPUT_FILE = INPUT_FILE;
        } else {
            throw new IllegalArgumentException("Input file cannot be empty");
        }
    }

    public void setOUTPUT_FILE(File OUTPUT_FILE) {
        if(OUTPUT_FILE != null) {
            this.OUTPUT_FILE = OUTPUT_FILE;
        } else {
            throw new IllegalArgumentException("Input file cannot be empty");
        }
    }

    public void setAIRPORT_LOOKUP_FILE(File AIRPORT_LOOKUP_FILE) {
        if(AIRPORT_LOOKUP_FILE != null) {
            this.AIRPORT_LOOKUP_FILE = AIRPORT_LOOKUP_FILE;
        } else {
            throw new IllegalArgumentException("Input file cannot be empty");
        }
    }
}
