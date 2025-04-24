package org.example.prettifier.itinerary.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VersionControl {
    public String getVersion() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("README.md"))) {
            String line = br.readLine();
            int start = line.indexOf('[');
            int end = line.indexOf(']', start);
            return line.substring(start + 1, end);
        }
    }
}
