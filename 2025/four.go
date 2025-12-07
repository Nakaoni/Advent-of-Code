package aoc

import (
	"bufio"
	"io"
)

const (
	FOUR = "FOUR"
)

type Direction struct {
	X int
	Y int
}

var directions = []Direction{
	{X: 0, Y: -1},
	{X: 1, Y: -1},
	{X: 1, Y: 0},
	{X: 1, Y: 1},
	{X: 0, Y: 1},
	{X: -1, Y: 1},
	{X: -1, Y: 0},
	{X: -1, Y: -1},
}

func GetFour(input io.Reader) int {
	sum := 0

	grid := make([][]rune, 0)

	scanner := bufio.NewScanner(input)
	for scanner.Scan() {
		byteList := scanner.Text()
		grid = append(grid, []rune(byteList))
	}

	for y := range grid {
		for x := range grid[0] {
			if isValid(grid, x, y) {
				sum++
			}
		}
	}

	return sum
}

func isValid(grid [][]rune, posX, posY int) bool {
	currentValue := grid[posY][posX]
	if currentValue != '@' {
		return false
	}

	count := 0
	sizeLine := len(grid[0])
	sizeGrid := len(grid)
	for _, p := range directions {
		x := posX + p.X
		y := posY + p.Y

		if x < 0 || x >= sizeLine {
			continue
		}
		if y < 0 || y >= sizeGrid {
			continue
		}

		if grid[y][x] == '@' {
			count++
		}
	}

	return count < 4
}
