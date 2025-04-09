package org.example.prettifier.common.exceptions;

import java.io.File;

public class FileNotFound extends AppExceptions{
    public FileNotFound(File file) {
        super(ErrorMessages.FILE_NOT_FOUND);
        System.err.println(file.getName());
    }
}
