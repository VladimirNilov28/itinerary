package org.example.prettifier.common.exceptions;

import java.io.File;

public class FileEmpty extends AppExceptions {
    public FileEmpty(File file) {
        super(ErrorMessages.FILE_IS_EMPTY);
        System.err.println(file.getName());
    }
}
