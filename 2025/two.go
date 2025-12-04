package aoc

import (
	"encoding/csv"
	"io"
	"strconv"
	"strings"
)

func GetTwo(input io.Reader) int {
	sum := 0

	r := csv.NewReader(input)

	record, err := r.Read()
	if err != nil {
		panic("Cannot read csv")
	}
	for _, rec := range record {
		inv := getInvalidIds(rec)

		for _, i := range inv {
			sum += i
		}
	}

	return sum
}

func getInvalidIds(s string) []int {
	ids := make([]int, 0)

	start, end := getRange(s)

	for i := start; i <= end; i++ {
		if isInvalidId(i) {
			ids = append(ids, i)
		}
	}

	return ids
}

func getRange(s string) (int, int) {
	numbers := strings.Split(s, "-")

	if len(numbers) != 2 {
		panic("Invalid range")
	}

	start, _ := strconv.Atoi(numbers[0])
	end, _ := strconv.Atoi(numbers[1])

	return start, end
}

func isInvalidId(number int) bool {
	s := strconv.Itoa(number)

	size := len(s)
	for i := size / 2; i > 0; i-- {
		splits := strings.Split(s, s[:i])

		if same(splits, func(a, b string) bool { return a == b }) {
			return true
		}
	}

	return false
}

func same[E comparable](elements []E, f func(a E, b E) bool) bool {
	el := elements[0]
	for _, e := range elements {
		if false == f(el, e) {
			return false
		}
	}

	return true
}
