package aoc

import (
	"bufio"
	"io"
	"strconv"
	"strings"
)

const (
	THREE  = "THREE"
	LENGTH = 12
)

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
	toRemove := size - LENGTH
	var stack []rune

	for _, b := range s {
		for len(stack) > 0 && toRemove > 0 && stack[len(stack)-1] < b {
			stack = stack[:len(stack)-1]
			toRemove--
		}
		stack = append(stack, b)
	}

	if toRemove > 0 {
		stack = stack[:len(stack)-toRemove]
	}
	result := stack[:LENGTH]

	var stringBuilder strings.Builder
	for _, r := range result {
		stringBuilder.WriteRune(r)
	}

	bank, err := strconv.Atoi(stringBuilder.String())
	if err != nil {
		panic(err)
	}
	return bank
}
