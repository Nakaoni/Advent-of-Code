package fr.nakaoni.aoc.day05;

import java.awt.event.AdjustmentEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import fr.nakaoni.aoc.DayResponse;

public class Day05 implements DayResponse {
    @Override
    public String getPart1Response(Stream<String> input) {
        int sum = 0;

        Map<Integer, List<Integer>> rules = getRules(input);
        List<List<Integer>> updates = getUpdates(input);

        updates.forEach((List<Integer> list) -> {
            sum += getMiddlePageNumberIfUpdateIsOrdered(list, rules);
        });

        return String.valueOf(sum);
    }

    @Override
    public String getPart2Response(Stream<String> input) {
        return "Implement me";
    }

    private Map<Integer, List<Integer>> getRules(Stream<String> input) {
        Map<Integer, List<Integer>> rules = new HashMap<>();

        input.forEach((String s) -> {
            String[] split = s.split("|");

            if (split.length != 2) {
                return;
            }

            Integer lhs = Integer.parseInt(split[0]);
            List<Integer> after = rules.getOrDefault(lhs, new ArrayList<>());

            Integer rhs = Integer.parseInt(split[1]);

            after.add(rhs);
            rules.putIfAbsent(lhs, after);
        });

        return rules;
    }

    private List<List<Integer>> getUpdates(Stream<String> input) {
        List<List<Integer>> list = new ArrayList<>();

        input.forEach((String s) -> {
            String[] split = s.split(",");
            List<Integer> innerList = new ArrayList<>();

            if (split.length <= 1) {
                return;
            }

            for (String sub : split) {
                innerList.add(Integer.parseInt(sub));
            }

            list.add(innerList);
        });

        return list;
    }

    private int getMiddlePageNumberIfUpdateIsOrdered(List<Integer> list, Map<Integer, List<Integer>> rules) {
        return 0;
    }
}
