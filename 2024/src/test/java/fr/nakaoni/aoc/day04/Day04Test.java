package fr.nakaoni.aoc.day04;

import fr.nakaoni.aoc.AdventOfCodeApplicationTest;
import fr.nakaoni.aoc.DayResponse;
import fr.nakaoni.aoc.utils.AOCReader;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class Day04Test {
    String EXAMPLE_FILE_PATH = "day04/example.txt";

    @Test
    public void testPart1Response() throws Exception {
        String expected = "18";

        Stream<String> input = AOCReader.read(Paths.get(AdventOfCodeApplicationTest.BASE_TEST_FOLDER_PATH, EXAMPLE_FILE_PATH));

        DayResponse day = new Day04();

        String result = day.getPart1Response(input);

        assertEquals(expected, result);
    }

    @Test
    public void testPart2Response() throws Exception {
        String expected = "";

        Stream<String> input = AOCReader.read(Paths.get(AdventOfCodeApplicationTest.BASE_TEST_FOLDER_PATH, EXAMPLE_FILE_PATH));

        DayResponse day = new Day04();

        String result = day.getPart2Response(input);

        assertEquals(expected, result);
    }
}
