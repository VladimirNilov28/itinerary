package org.example.prettifier.common;


public enum ProgramMessages {
    CORRECT_PROGRAM_USAGE("""
            Default usage:
                $ java -cp target/classes org.example.prettifier.Prettifier <INPUT FILE> <OUTPUT FILE> <AIRPORT LOOKUP FILE>
            """);


    private final String message;

    ProgramMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
