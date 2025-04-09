package org.example.prettifier.common.exceptions;

import org.example.prettifier.common.ProgramMessages;

public class ArgsFormatException extends AppExceptions {
    public ArgsFormatException(ProgramMessages message) {
        super(ErrorMessages.ARGS_FORMAT);
        System.err.println(message);
    }
}
