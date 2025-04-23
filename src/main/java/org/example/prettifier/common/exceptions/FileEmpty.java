package org.example.prettifier.common.exceptions;

public class FileEmpty extends AppExceptions {
    public FileEmpty(String file) {
        super(ErrorMessages.FILE_IS_EMPTY + file);
    }
}
