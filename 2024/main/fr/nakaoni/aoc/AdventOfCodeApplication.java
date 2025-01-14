package fr.nakaoni.aoc;

import java.nio.file.Paths;

import fr.nakaoni.aoc.day01.Day01;
import fr.nakaoni.aoc.day02.Day02;
import fr.nakaoni.aoc.utils.AOCReader;

public class AdventOfCodeApplication {
    public static final String BASE_FOLDER_PATH = "main/fr/nakaoni/aoc";

    public static void main(String[] args) {
        try {
            DayResponse day01 = new Day01();
            printResponse(day01.getClass().getSimpleName(), day01.getPart1Response(AOCReader.read(Paths.get(BASE_FOLDER_PATH, "day01/assets/input.txt"))));
            printResponse(day01.getClass().getSimpleName(), day01.getPart2Response(AOCReader.read(Paths.get(BASE_FOLDER_PATH, "day01/assets/input.txt"))));

            System.out.println("=========");

            DayResponse day02 = new Day02();
            printResponse(day02.getClass().getSimpleName(), day02.getPart1Response(AOCReader.read(Paths.get(BASE_FOLDER_PATH, "day02/assets/input.txt"))));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void printResponse(String className, String response) {
        System.out.format("%s:\n", className);
        System.out.format("\tResponse is \"%s\"\n", response);
    }
}
