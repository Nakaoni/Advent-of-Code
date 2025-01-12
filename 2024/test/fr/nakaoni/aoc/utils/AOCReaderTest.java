package fr.nakaoni.aoc.utils;

import static org.junit.Assert.assertEquals;

import java.nio.file.Paths;

import org.junit.Test;

public class AOCReaderTest {
    final String test_file_path = "assets/test_file.txt";
    final String test_dir_path = "2024/test/fr/nakaoni/aoc";

    @Test
    public void testRead() throws Exception {
        String expected = "I am a test file.";

        String content = AOCReader.read(Paths.get(test_dir_path, test_file_path).toAbsolutePath());

        assertEquals(expected, content);
    }
}
