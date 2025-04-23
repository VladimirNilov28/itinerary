package org.example.prettifier.common.exceptions;

public class AppExceptions extends RuntimeException {
    public AppExceptions(ErrorMessages error) {
        super(error.toString());
    }
    public AppExceptions(String message) {
        super(message);
    }
}
