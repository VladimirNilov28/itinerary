package org.example.prettifier.common.enums;


import org.example.prettifier.itinerary.model.Link;

public enum ProgramMessages {
    FILE_WRITE_OK("[ \u001B[32mOK\u001B[0m ] Writing to file: "),
    FILE_WRITE_WARN("[ \u001B[33mWARN\u001B[0m ] Something went wrong when writing to file "),;


    private final String message;

    ProgramMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
