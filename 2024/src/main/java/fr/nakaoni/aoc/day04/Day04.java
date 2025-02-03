package fr.nakaoni.aoc.day04;

import java.util.stream.Stream;

import fr.nakaoni.aoc.DayResponse;

public class Day04 implements DayResponse {

    private class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    @Override
    public String getPart1Response(Stream<String> input) {
        char[][] matrix = getMatrix(input);

        return String.valueOf(sumOfXmas(matrix));
    }

    @Override
    public String getPart2Response(Stream<String> input) {
        char[][] matrix = getMatrix(input);

        return String.valueOf(sumOfMas(matrix));
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

    private int sumOfMas(char[][] matrix) {
        int sum = 0;
        int numberOfRows = matrix.length;
        int numberOfColumns = matrix[0].length;

        /**
         *         M   M      M   S       S   S       S   M
         *           A          A           A           A
         *         S   S      M   S       M   M       S   M
         * M = [[ -1, -1 ], [ -1, -1 ], [ -1,  1 ], [  1,  1 ]]
         * M = [[  1, -1 ], [ -1,  1 ], [  1,  1 ], [  1, -1 ]]
         * S = [[ -1,  1 ], [  1, -1 ], [ -1, -1 ], [ -1, -1 ]]
         * S = [[  1,  1 ], [  1,  1 ], [  1, -1 ], [ -1,  1 ]]
         */
        Point[][] xMas = {
            { new Point(-1, -1), new Point(-1, -1), new Point(-1, 1), new Point(1, 1) },
            { new Point(1, -1), new Point(-1, 1), new Point(1, 1), new Point(1, -1) },
            { new Point(-1, 1), new Point(1, -1), new Point(-1, -1), new Point(-1, -1) },
            { new Point(1, 1), new Point(1, 1), new Point(1, -1), new Point(-1, 1) },
        };

        for (int i = 1; i < numberOfRows - 1; i++) {
            for (int j = 1; j < numberOfColumns - 1; j++) {
                char current = matrix[i][j];
                if ('A' != current) {
                    continue;
                }

                if (
                    isXmas(matrix, new Point(i, j), xMas[0][0], xMas[1][0], xMas[2][0], xMas[3][0]) ||
                    isXmas(matrix, new Point(i, j), xMas[0][1], xMas[1][1], xMas[2][1], xMas[3][1]) ||
                    isXmas(matrix, new Point(i, j), xMas[0][2], xMas[1][2], xMas[2][2], xMas[3][2]) ||
                    isXmas(matrix, new Point(i, j), xMas[0][3], xMas[1][3], xMas[2][3], xMas[3][3])
                ) {
                    sum++;
                }
            }
        }

        return sum;
    }

    private boolean isXmas(
        char[][] matrix,
        Point currentPoint,
        Point mFirstPoint,
        Point mSecondPoint,
        Point sFirstPoint,
        Point sSecondPoint
    ) {
        if ('M' != matrix[currentPoint.x - mFirstPoint.x][ currentPoint.y - mFirstPoint.y]) {
            return false;
        }

        if ('M' != matrix[currentPoint.x - mSecondPoint.x][ currentPoint.y - mSecondPoint.y]) {
            return false;
        }

        if ('S' != matrix[currentPoint.x - sFirstPoint.x][ currentPoint.y - sFirstPoint.y]) {
            return false;
        }

        if ('S' != matrix[currentPoint.x - sSecondPoint.x][ currentPoint.y - sSecondPoint.y]) {
            return false;
        }
        
        return true;
    }
}
