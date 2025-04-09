package org.example.prettifier.common.exceptions;

import java.io.File;

public class FileEmpty extends AppExceptions {
    public FileEmpty() {
        super(ErrorMessages.FILE_IS_EMPTY);
    }
}
