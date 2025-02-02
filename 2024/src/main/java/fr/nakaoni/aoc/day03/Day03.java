package fr.nakaoni.aoc.day03;

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
        boolean canCount = true;

        String mulPattern = "mul\\((\\d+,\\d+)\\)";
        String doPattern = "do\\(\\)";
        String dontPattern = "don't\\(\\)";

        Pattern globalPattern = Pattern.compile(String.format("%s|%s|%s", mulPattern, doPattern, dontPattern));
        Matcher globalMatcher = globalPattern.matcher(input.toList().toString());


        while (globalMatcher.find()) {
            String value = globalMatcher.group();

            Pattern mulP = Pattern.compile(mulPattern);
            Matcher mulM = mulP.matcher(value);

            if (mulM.find()) {
                if (canCount) {
                    String s = mulM.group(1);
                    String[] pair = s.split(",");

                    sum = sum + Integer.parseInt(pair[0]) * Integer.parseInt(pair[1]);
                    continue;
                }
            }


            Pattern doP = Pattern.compile(doPattern);
            Matcher doM = doP.matcher(value);

            if (doM.find()) {
                canCount = true;
            }

            Pattern dontP = Pattern.compile(dontPattern);
            Matcher dontM = dontP.matcher(value);

            if (dontM.find()) {
                canCount = false;
            }

        }

        return String.valueOf(sum);
    }
}
