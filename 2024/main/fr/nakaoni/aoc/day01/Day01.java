package fr.nakaoni.aoc.day01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import fr.nakaoni.aoc.DayResponse;

public class Day01 implements DayResponse {

    @Override
    public String getPart1Response(Stream<String> input) throws Exception {
        
        List<Integer> leftNumbers = new ArrayList<>();
        List<Integer> rightNumbers = new ArrayList<>();

        for (String line: input.toList()) {
            String[] members = line.split("   ");

            int nbMembers = members.length;
            if (nbMembers != 2) {
                throw new Exception(String.format("Expected 2 items, Got %i", nbMembers));
            }

            leftNumbers.add(Integer.parseInt(members[0]));
            rightNumbers.add(Integer.parseInt(members[1]));
        }

        Collections.sort(leftNumbers);
        Collections.sort(rightNumbers);

        int sum = 0;
        for (int i = 0; i < leftNumbers.size(); i++) {
            sum += Math.abs(leftNumbers.get(i) - rightNumbers.get(i));
        }

        return String.valueOf(sum);
    }

}
