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

	hasCanged := false
	for {
		hasCanged = false
		for y := range grid {
			for x := range grid[0] {
				currentValue := grid[y][x]
				if currentValue != '@' {
					continue
				}

				count := countRemovable(grid, x, y)
				if count < 4 {
					sum++
					grid[y][x] = '.'
					hasCanged = true
				}
			}
		}

		if !hasCanged {
			break
		}
	}

	return sum
}

func countRemovable(grid [][]rune, posX, posY int) int {
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

	return count
}
