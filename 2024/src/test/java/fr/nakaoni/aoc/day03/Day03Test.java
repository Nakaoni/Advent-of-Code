package fr.nakaoni.aoc.day03;

import fr.nakaoni.aoc.AdventOfCodeApplicationTest;
import fr.nakaoni.aoc.DayResponse;
import fr.nakaoni.aoc.utils.AOCReader;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class Day03Test {
    String EXAMPLE_FILE_PATH = "day03/example.txt";
    String EXAMPLE2_FILE_PATH = "day03/example2.txt";

    @Test
    public void testPart1Response() throws Exception {
        String expected = "161";

        Stream<String> input = AOCReader.read(Paths.get(AdventOfCodeApplicationTest.BASE_TEST_FOLDER_PATH, EXAMPLE_FILE_PATH));

        DayResponse day = new Day03();

        String result = day.getPart1Response(input);

        assertEquals(expected, result);
    }

    @Test
    public void testPart2Response() throws Exception {
        String expected = "48";

        Stream<String> input = AOCReader.read(Paths.get(AdventOfCodeApplicationTest.BASE_TEST_FOLDER_PATH, EXAMPLE2_FILE_PATH));

        DayResponse day = new Day03();

        String result = day.getPart2Response(input);

        assertEquals(expected, result);
    }
}
