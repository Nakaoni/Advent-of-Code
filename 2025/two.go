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

	firstPart := s[:len(s)/2]
	secondPart := s[len(s)/2:]

	return firstPart == secondPart
}
