package aoc

import (
	"bufio"
	"io"
	"strconv"
	"strings"
)

const (
	FIVE = "FIVE"
)

var ranges [][]int

func GetFive(input io.Reader) int {
	sum := 0
	startInventory := false

	scanner := bufio.NewScanner(input)
	for scanner.Scan() {
		text := scanner.Text()

		if text == "" {
			startInventory = true
			continue
		}

		if startInventory {
			if isFresh(text) {
				sum++
			}
		} else {
			addRanges(text)
		}
	}

	return sum
}

func addRanges(s string) {
	sp := strings.Split(s, "-")

	if len(sp) != 2 {
		panic("Invalid range")
	}

	start, err := strconv.Atoi(sp[0])
	if err != nil {
		panic(err)
	}

	end, err := strconv.Atoi(sp[1])
	if err != nil {
		panic(err)
	}

	ranges = append(ranges, []int{start, end})
}

func isFresh(s string) bool {
	id, err := strconv.Atoi(s)
	if err != nil {
		panic(err)
	}

	for _, r := range ranges {
		if id >= r[0] && id <= r[1] {
			return true
		}
	}

	return false
}
