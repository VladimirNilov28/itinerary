package org.example.prettifier.common.enums;

public enum ProgramMessages {
    FILE_HAS_WRITE("[ \u001B[32mOK\u001B[0m ] Writing to file: ");


    private final String message;

    ProgramMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
