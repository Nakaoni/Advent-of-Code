package fr.nakaoni.aoc;

import java.util.stream.Stream;

public interface DayResponse {
    public String getPart1Response(Stream<String> input) throws Exception;
    public String getPart2Response(Stream<String> input) throws Exception;
}
