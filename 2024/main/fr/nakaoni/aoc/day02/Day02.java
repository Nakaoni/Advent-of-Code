package fr.nakaoni.aoc.day02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import fr.nakaoni.aoc.DayResponse;

public class Day02 implements DayResponse {
    public enum Level {
        INITIALIZED,
        INCREASING,
        DECREASING,
        STABLE
    }

    // @Override
    // public String getPart1Response(Stream<String> input) throws Exception {
    //     int sum = 0;

    //     for (String line: input.toList()) {
    //         boolean passedFirstCheck = true;
    //         boolean passedSecondCheck = true;
    //         Level currentState = Level.INITIALIZED;

    //         String[] list = line.split(" ");

    //         int len = list.length;
    //         if (len == 0) {
    //             throw new Exception(String.format("List is empty", len));
    //         }

    //         int[] numbers = new int[len];
    //         numbers[0] = Integer.parseInt(list[0]);
    //         for (int i = 1; i < len; i++) {
    //             int currentNumber = Integer.parseInt(list[i]);

    //             passedFirstCheck = checkDiffBetweenTwoAdjacent(currentNumber, numbers[i - 1]);

    //             Level state = getLevelBetweenTwoAdjacent(numbers[i - 1], currentNumber);
    //             if (currentState.compareTo(Level.INITIALIZED) == 0) {
    //                 currentState = state;
    //             }

    //             passedSecondCheck = currentState.equals(state);
    //             numbers[i] = currentNumber;
    //         }

    //         if (!passedFirstCheck || !passedSecondCheck) {
    //             continue;
    //         }

    //         sum++;
    //     }

    //     return String.valueOf(sum);
    // }

    /**
     * Solution from the community
     * 
     * Using a set
     */
    @Override
    public String getPart1Response(Stream<String> input) throws Exception {
        int sum = 0;

        for (String line: input.toList()) {
            Set<Integer> safePositive = new HashSet<>(3);
            safePositive.add(1);
            safePositive.add(2);
            safePositive.add(3);
            Set<Integer> safeNegative = new HashSet<>(3);
            safeNegative.add(-1);
            safeNegative.add(-2);
            safeNegative.add(-3);

            String[] list = line.split(" ");

            int len = list.length;
            if (len == 0) {
                throw new Exception(String.format("List is empty", len));
            }

            int[] numbers = new int[len];
            numbers[0] = Integer.parseInt(list[0]);
            for (int i = 1; i < len; i++) {
                int currentNumber = Integer.parseInt(list[i]);
                numbers[i] = currentNumber;

                safePositive.add(currentNumber - numbers[i - 1]);
                safeNegative.add(currentNumber - numbers[i - 1]);
            }

            if (safePositive.size() > 3 && safeNegative.size() > 3) {
                continue;
            }

            sum++;
        }

        return String.valueOf(sum);
    }

    @Override
    public String getPart2Response(Stream<String> input) throws Exception {
        int sum = 0;

        for (String line: input.toList()) {
            boolean passedFirstCheck = true;
            boolean passedSecondCheck = true;
            boolean alreadyHadBadLevel = false;
            Level currentState = Level.INITIALIZED;

            String[] list = line.split(" ");

            int len = list.length;
            if (len == 0) {
                throw new Exception(String.format("List is empty", len));
            }

            List<Integer> numbers = new ArrayList<>(len);
            numbers.add(Integer.parseInt(list[0]));
            for (int i = 1; i < len; i++) {
                int currentNumber = Integer.parseInt(list[i]);

                passedFirstCheck = checkDiffBetweenTwoAdjacent(currentNumber, numbers.get(numbers.size() - 1));

                if (!passedFirstCheck) {
                    if (alreadyHadBadLevel) {
                        break;
                    }

                    alreadyHadBadLevel = true;
                    // reset 1st fail
                    passedFirstCheck = true;
                    continue;
                }

                Level state = getLevelBetweenTwoAdjacent(numbers.get(numbers.size() - 1), currentNumber);
                if (currentState.compareTo(Level.INITIALIZED) == 0) {
                    currentState = state;
                }

                passedSecondCheck = currentState.equals(state);
                if (!passedSecondCheck) {
                    if (alreadyHadBadLevel) {
                        break;
                    }

                    alreadyHadBadLevel = true;
                    // reset 1st fail
                    passedSecondCheck = true;
                    continue;
                }

                numbers.add(currentNumber);
            }

            if (!passedFirstCheck || !passedSecondCheck) {
                continue;
            }

            sum++;
        }

        return String.valueOf(sum);
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

        if (a == b) {
            return Level.STABLE;
        }

        return Level.INCREASING;
    }
}
