package org.example.prettifier.itinerary.model;

import lombok.Getter;
import org.example.prettifier.common.exceptions.ArgsFormatException;
import org.example.prettifier.common.exceptions.FileEmpty;
import org.example.prettifier.common.exceptions.FileNotFound;

import java.io.File;

@Getter
public class Link {
    private File INPUT_FILE;
    private File OUTPUT_FILE;
    private File AIRPORT_LOOKUP_FILE;

    public void setINPUT_FILE(String INPUT_FILE) {
        File file = new File(INPUT_FILE);
        if(file.exists() && file.length() != 0) {
            this.INPUT_FILE = new File(INPUT_FILE);
        } else {
            throw (!file.exists()
                    ? new FileNotFound(INPUT_FILE)
                    : new FileEmpty(INPUT_FILE));
        }
    }

    public void setOUTPUT_FILE(String OUTPUT_FILE) {
        File file = new File(OUTPUT_FILE);
        if(file.exists() && file.length() != 0) {
            this.OUTPUT_FILE = new File(OUTPUT_FILE);
        } else {
            throw (!file.exists()
                    ? new FileNotFound(OUTPUT_FILE)
                    : new FileEmpty(OUTPUT_FILE));
        }
    }

    public void setAIRPORT_LOOKUP_FILE(String AIRPORT_LOOKUP_FILE) {
        File file = new File(AIRPORT_LOOKUP_FILE);
        if(file.exists() && file.length() != 0) {
            this.AIRPORT_LOOKUP_FILE = new File(AIRPORT_LOOKUP_FILE);
        } else {
            throw (!file.exists()
                    ? new FileNotFound(AIRPORT_LOOKUP_FILE)
                    : new FileEmpty(AIRPORT_LOOKUP_FILE));
        }
    }

}
