package fr.nakaoni.aoc.day04;

import java.util.stream.Stream;

import fr.nakaoni.aoc.DayResponse;

public class Day04 implements DayResponse {
    @Override
    public String getPart1Response(Stream<String> input) {
        char[][] matrix = getMatrix(input);

        return String.valueOf(sumOfXmas(matrix));
    }

    @Override
    public String getPart2Response(Stream<String> input) {
        return "Implement me";
    }

    private char[][] getMatrix(Stream<String> input) {
        String[] list = input.toList().toArray(new String[0]);

        long numberOfRows = list.length;
        long numberOfColumns = list[0].length();

        char[][] matrix = new char[(int) numberOfRows][(int) numberOfColumns];

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                matrix[i][j] = list[i].charAt(j);
            }
        }

        return matrix;
    }

    private int sumOfXmas(char[][] matrix) {
        int sum = 0;
        int numberOfRows = matrix.length;
        int numberOfColumns = matrix[0].length;

        int[][] directions = {
                { 0, 1 },
                { 0, -1 },
                { 1, 0 },
                { -1, 0 },
                { 1, 1 },
                { 1, -1 },
                { -1, 1 },
                { -1, -1 },
        };

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                char current = matrix[i][j];
                if ('X' != current) {
                    continue;
                }

                sum += plusOneIfXmasInThisDirection(matrix, directions[0], i, j, 0);
                sum += plusOneIfXmasInThisDirection(matrix, directions[1], i, j, 0);
                sum += plusOneIfXmasInThisDirection(matrix, directions[2], i, j, 0);
                sum += plusOneIfXmasInThisDirection(matrix, directions[3], i, j, 0);
                sum += plusOneIfXmasInThisDirection(matrix, directions[4], i, j, 0);
                sum += plusOneIfXmasInThisDirection(matrix, directions[5], i, j, 0);
                sum += plusOneIfXmasInThisDirection(matrix, directions[6], i, j, 0);
                sum += plusOneIfXmasInThisDirection(matrix, directions[7], i, j, 0);
            }
        }

        return sum;
    }

    private int plusOneIfXmasInThisDirection(char[][] matrix, int[] direction, int x, int y,
            int currentXmasIndexToFind) {
        char[] xmas = { 'M', 'A', 'S' };

        if (currentXmasIndexToFind >= xmas.length) {
            return 1;
        }

        int numberOfRows = matrix.length;
        int numberOfColumns = matrix[0].length;

        int newX = x + direction[0];
        int newY = y + direction[1];

        if (newX < 0 || newX >= numberOfRows || newY < 0 || newY >= numberOfColumns) {
            return 0;
        }

        char nextPoint = matrix[newX][newY];

        if (xmas[currentXmasIndexToFind] == nextPoint) {
            return plusOneIfXmasInThisDirection(matrix, direction, newX, newY, currentXmasIndexToFind + 1);
        }

        return 0;
    }
}
