package org.example.prettifier.itinerary.model;

import lombok.Getter;
import org.example.prettifier.common.ProgramMessages;
import org.example.prettifier.common.exceptions.ArgsFormatException;
import org.example.prettifier.common.exceptions.FileEmpty;
import org.example.prettifier.common.exceptions.FileNotFound;
import org.example.prettifier.itinerary.validators.FileValidator;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@Getter
public class Link {
    private File INPUT_FILE;
    private File OUTPUT_FILE;
    private File AIRPORT_LOOKUP_FILE;

    public void setINPUT_FILE(String INPUT_FILE) {
        File file = new File(INPUT_FILE);
        FileValidator.isFileExistsAndNotEmpty(file,
                new FileNotFound(INPUT_FILE),
                new FileEmpty(INPUT_FILE));
        this.INPUT_FILE = new File(INPUT_FILE);
    }

    public void setOUTPUT_FILE(String OUTPUT_FILE) throws IOException {
        this.OUTPUT_FILE = new File(OUTPUT_FILE);
    }

    public void setAIRPORT_LOOKUP_FILE(String AIRPORT_LOOKUP_FILE) {
        File file = new File(AIRPORT_LOOKUP_FILE);
        FileValidator.isFileExistsAndNotEmpty(file,
                new FileNotFound(AIRPORT_LOOKUP_FILE),
                new FileEmpty(AIRPORT_LOOKUP_FILE));
        this.AIRPORT_LOOKUP_FILE = new File(AIRPORT_LOOKUP_FILE);
    }

}
