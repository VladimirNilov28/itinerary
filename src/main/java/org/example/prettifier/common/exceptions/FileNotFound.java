package org.example.prettifier.common.exceptions;

import java.io.File;

public class FileNotFound extends AppExceptions{
    public FileNotFound(String file) {
        super(ErrorMessages.FILE_NOT_FOUND.getMessage() + file);
    }
}
