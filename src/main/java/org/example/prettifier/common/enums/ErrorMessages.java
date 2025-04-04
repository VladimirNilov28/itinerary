package org.example.prettifier.common.enums;

import lombok.Getter;

@Getter
public enum ErrorMessages {
    AIRPORT_LOOKUP_MALFORMED("Airport-lookup malformed"),
    AIRPORT_LOOKUP_EMPTY("Airport-lookup is empty"),
    AIRPORT_LOOKUP_NOT_FOUND("Airport-lookup not found"),
    INPUT_FILE_NOT_FOUND("Input file not found"),
    INPUT_FILE_EMPTY("Input file is empty"),
    OUTPUT_FILE_NOT_FOUND("Output file not found"),
    DATE_TIME_FORMAT_EXCEPTION("Incorrect date/time format"),
    FILE_HASNT_WRITE("[ \u001B[31mOK\u001B[0m ] Writing to file: ");

    String message;
    ErrorMessages(String message) {
        this.message = message;
    }

}
