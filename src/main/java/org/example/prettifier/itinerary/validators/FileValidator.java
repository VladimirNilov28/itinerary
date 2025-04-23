package org.example.prettifier.itinerary.validators;

import org.example.prettifier.common.exceptions.AppExceptions;

import java.io.File;

public class FileValidator {
    public static void isFileExistsAndNotEmpty(File file, AppExceptions fileNotFound, AppExceptions fileIsEmpty) {
        if (!file.exists()) throw fileNotFound;
        if (file.length() == 0) throw fileIsEmpty;
    }
}
