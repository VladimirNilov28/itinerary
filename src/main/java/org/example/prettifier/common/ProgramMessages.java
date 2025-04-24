package org.example.prettifier.common;


public enum ProgramMessages {
    CORRECT_PROGRAM_USAGE("Default usage -> $ java -cp target/classes org.example.prettifier.Prettifier <INPUT FILE> <OUTPUT FILE> <AIRPORT LOOKUP FILE>"),
    CREATE_OUTPUT_FILE("[\u001B[33m WARN \u001B[0m] Output file does not exist. Do you want to create it? [y/n] "),
    OVERWRITE_OUTPUT_FILE("[\u001B[33m WARN \u001B[0m] Output file is going to be overwritten. Do you want to overwrite it? [y/n] "),
    OPERATION_OK("[\u001B[32m OK \u001B[0m] Operation was performed successfully.");

    private final String message;

    ProgramMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
