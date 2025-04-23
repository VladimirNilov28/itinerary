package org.example.prettifier;

import java.io.IOException;

public class Prettifier {
    public static void main(String[] args) throws IOException {
        new PrettifierRunner().run(args);
    }
}

//TODO Сделать оповещение о создании output файла или оповещение о его перезаписи
