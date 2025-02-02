package fr.nakaoni.aoc.day03;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import fr.nakaoni.aoc.DayResponse;

public class Day03 implements DayResponse {
    @Override
    public String getPart1Response(Stream<String> input) {
        int sum = 0;

        Pattern p = Pattern.compile("mul\\((\\d+,\\d+)\\)", Pattern.MULTILINE);
        Matcher m = p.matcher(input.toList().toString());

        while (m.find()) {
            String s = m.group(1);
            String[] pair = s.split(",");

            sum = sum + Integer.parseInt(pair[0]) * Integer.parseInt(pair[1]);
        }

        return String.valueOf(sum);
    }

    @Override
    public String getPart2Response(Stream<String> input) {
        int sum = 0;

        Pattern p = Pattern.compile("\\(?do\\(\\)\\)*mul\\((\\d+,\\d+)\\)", Pattern.MULTILINE);
        Matcher m = p.matcher(input.toList().toString());

        while (m.find()) {
            String s = m.group(1);
            String[] pair = s.split(",");

            sum = sum + Integer.parseInt(pair[0]) * Integer.parseInt(pair[1]);
        }

        return String.valueOf(sum);
    }
}
