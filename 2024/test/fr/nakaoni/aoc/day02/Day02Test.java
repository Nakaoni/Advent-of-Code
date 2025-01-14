package fr.nakaoni.aoc.day02;

import static org.junit.Assert.assertEquals;

import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.Test;

import fr.nakaoni.aoc.AdventOfCodeApplicationTest;
import fr.nakaoni.aoc.DayResponse;
import fr.nakaoni.aoc.utils.AOCReader;

public class Day02Test {
    String EXAMPLE_FILE_PATH = "day02/example.txt";

    @Test
    public void testPart1Response() throws Exception {
        String expected = "2";

        Stream<String> input = AOCReader.read(Paths.get(AdventOfCodeApplicationTest.BASE_TEST_FOLDER_PATH, EXAMPLE_FILE_PATH));

        DayResponse day = new Day02();

        String result = day.getPart1Response(input);

        assertEquals(expected, result);
    }
}
