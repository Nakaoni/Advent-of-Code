package fr.nakaoni.aoc.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AOCReader {
    public static String read(String filepath) throws IOException
    {
        Path path = Path.of(filepath);

        boolean isReadableFile = Files.isReadable(path);

        if (!isReadableFile) {
            throw new FileNotFoundException();
        }

        return Files.readString(path);
    }
}
