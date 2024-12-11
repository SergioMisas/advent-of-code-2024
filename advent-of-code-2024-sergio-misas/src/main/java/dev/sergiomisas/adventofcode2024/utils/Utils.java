package dev.sergiomisas.adventofcode2024.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Collectors;

public class Utils {
    private Utils() {
    }

    public static String readFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
