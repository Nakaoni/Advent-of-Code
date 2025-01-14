package fr.nakaoni.aoc.day02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import fr.nakaoni.aoc.DayResponse;

public class Day02 implements DayResponse {
    public enum Level {
        INITIALIZED,
        INCREASING,
        DECREASING
    }

    @Override
    public String getPart1Response(Stream<String> input) throws Exception {
        int sum = 0;

        for (String line: input.toList()) {
            boolean passedFirstCheck = true;
            boolean passedSecondCheck = true;
            Level currentState = Level.INITIALIZED;

            String[] list = line.split(" ");

            int len = list.length;
            if (len == 0) {
                throw new Exception(String.format("List is empty", len));
            }

            int[] numbers = new int[len];
            numbers[0] = Integer.parseInt(list[0]);
            for (int i = 1; i < len; i++) {
                int currentNumber = Integer.parseInt(list[i]);

                passedFirstCheck = checkDiffBetweenTwoAdjacent(currentNumber, numbers[i - 1]);

                Level state = getLevelBetweenTwoAdjacent(numbers[i - 1], currentNumber);
                if (currentState.compareTo(Level.INITIALIZED) == 0) {
                    currentState = state;
                }

                passedSecondCheck = currentState.equals(state);
                if (!passedFirstCheck || !passedSecondCheck) {
                    break;
                }

                numbers[i] = currentNumber;
            }

            if (!passedFirstCheck || !passedSecondCheck) {
                continue;
            }

            sum++;
        }

        return String.valueOf(sum);
    }

    @Override
    public String getPart2Response(Stream<String> input) throws Exception {
        return "TODO: to implement";
    }

    /**
     * Returns if two numbers difference are within the range 1 to 3
     */
    private boolean checkDiffBetweenTwoAdjacent(int a, int b) {
        int diff = Math.abs(a - b);

        return diff >= 1 && diff <= 3;
    }

    private Level getLevelBetweenTwoAdjacent(int a, int b) {
        if (a > b) {
            return Level.DECREASING;
        }

        return Level.INCREASING;

    }
}
