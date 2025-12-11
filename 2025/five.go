package aoc

import (
	"bufio"
	"io"
	"slices"
	"strconv"
	"strings"
)

const (
	FIVE = "FIVE"
)

var ranges [][]int

func GetFive(input io.Reader) int {
	sum := 0

	scanner := bufio.NewScanner(input)
	for scanner.Scan() {
		text := scanner.Text()

		if text == "" {
			break
		}

		addRanges(text)
	}

	sortRanges()

	current := -1
	for _, r := range ranges {
		start := r[0]
		end := r[1]

		if current >= start {
			start = current + 1
		}
		if start <= end {
			sum += end - start + 1
		}

		current = max(current, end)
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

func sortRanges() {
	slices.SortFunc(ranges, func(a []int, b []int) int {
		if a[0] < b[0] {
			return -1
		}
		return 1
	})
}
