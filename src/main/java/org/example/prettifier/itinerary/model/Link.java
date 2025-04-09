package org.example.prettifier.itinerary.model;

import lombok.Getter;
import org.example.prettifier.common.ProgramMessages;
import org.example.prettifier.common.exceptions.ArgsFormatException;

import java.io.File;

@Getter
public class Link {
    private File INPUT_FILE;
    private File OUTPUT_FILE;
    private File AIRPORT_LOOKUP_FILE;

    public void setINPUT_FILE(String INPUT_FILE) {
        if(INPUT_FILE != null && !INPUT_FILE.isEmpty()) {
            this.INPUT_FILE = new File(INPUT_FILE);
        } else {
            throw new ArgsFormatException(ProgramMessages.CORRECT_PROGRAM_USAGE);
        }
    }

    public void setOUTPUT_FILE(String OUTPUT_FILE) {
        if(OUTPUT_FILE != null && !OUTPUT_FILE.isEmpty()) {
            this.OUTPUT_FILE = new File(OUTPUT_FILE);
        } else {
            throw new ArgsFormatException(ProgramMessages.CORRECT_PROGRAM_USAGE);
        }
    }

    public void setAIRPORT_LOOKUP_FILE(String AIRPORT_LOOKUP_FILE) {
        if(AIRPORT_LOOKUP_FILE != null && !AIRPORT_LOOKUP_FILE.isEmpty()) {
            this.AIRPORT_LOOKUP_FILE = new File(AIRPORT_LOOKUP_FILE);
        } else {
            throw new ArgsFormatException(ProgramMessages.CORRECT_PROGRAM_USAGE);
        }
    }

}
