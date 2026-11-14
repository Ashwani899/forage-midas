package com.jpmc.midascore;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class FileLoader {
    public String[] loadStrings(String path) {
        try (InputStream inputStream = getClass().getResourceAsStream(path)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Test resource not found: " + path);
            }
            String fileText = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            return fileText.split("\\R");
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read test resource: " + path, e);
        }
    }
}
