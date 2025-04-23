package org.example.prettifier.common.exceptions;

import lombok.Getter;

@Getter
public enum ErrorMessages {
    FILE_NOT_FOUND("[\u001B[31m ERR \u001B[0m] File not found: "),
    FILE_IS_EMPTY("[\u001B[31m ERR \u001B[0m] File is empty: "),
    AIRPORT_LOOKUP_MALFORMED("[\u001B[31m ERR \u001B[0m] Airport Lookup file is malformed"),
    ARGS_FORMAT("[\u001B[31m ERR \u001B[0m] Invalid args format ");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}