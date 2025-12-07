package aoc

import (
	"bufio"
	"io"
	"strconv"
	"strings"
)

const THREE = "THREE"

func GetThree(input io.Reader) int {
	sum := 0

	scanner := bufio.NewScanner(input)
	for scanner.Scan() {
		bankString := scanner.Text()
		sum += getBank(bankString)
	}

	return sum
}

func getBank(s string) int {
	size := len(s)
	highestIndex := findHighestIndex(s)

	var firstDigit byte
	var secondDigit byte
	if highestIndex < size-1 {
		firstDigit = s[highestIndex]
		s = s[highestIndex+1:]
		secondDigit = s[findHighestIndex(s)]
	} else {
		secondDigit = s[highestIndex]
		s = s[:highestIndex]
		firstDigit = s[findHighestIndex(s)]
	}

	var stringBuilder strings.Builder
	stringBuilder.WriteByte(firstDigit)
	stringBuilder.WriteByte(secondDigit)

	bank, err := strconv.Atoi(stringBuilder.String())
	if err != nil {
		panic(err)
	}
	return bank
}

func findHighestIndex(s string) int {
	highestIndex := 0
	size := len(s)
	for i := highestIndex + 1; i < size; i++ {
		digit := convertToInt(string(s[i]))

		if digit > convertToInt(string(s[highestIndex])) {
			highestIndex = i
		}
	}

	return highestIndex
}

func convertToInt(s string) int {
	i, err := strconv.Atoi(s)
	if err != nil {
		panic(err)
	}
	return i
}
