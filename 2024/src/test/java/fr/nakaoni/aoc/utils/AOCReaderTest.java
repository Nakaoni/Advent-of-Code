package fr.nakaoni.aoc.utils;

import static org.junit.Assert.assertEquals;

import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import fr.nakaoni.aoc.AdventOfCodeApplicationTest;

public class AOCReaderTest {
    final String TEST_FILE_PATH = "test_file.txt";

    @Test
    public void testRead() throws Exception {
        String expected = "I am a test file.";

        Stream<String> content = AOCReader.read(Paths.get(AdventOfCodeApplicationTest.BASE_TEST_FOLDER_PATH, TEST_FILE_PATH));

        List<String> l = content.toList();

        assertEquals(1, l.size());
        assertEquals(expected, l.get(0));
    }
}
