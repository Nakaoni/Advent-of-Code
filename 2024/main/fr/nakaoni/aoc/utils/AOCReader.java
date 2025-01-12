package fr.nakaoni.aoc.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AOCReader {
    /**
     * @param Path path
     * @return String
     * 
     * @throws IOException
     */
    public static String read(Path path) throws IOException
    {
        boolean isReadableFile = Files.isReadable(path);

        if (!isReadableFile) {
            throw new FileNotFoundException();
        }

        return Files.readString(path);
    }
}
