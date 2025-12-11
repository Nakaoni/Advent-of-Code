package aoc

import (
	"bufio"
	"io"
	"regexp"
	"strconv"
)

const (
	SIX = "SIX"
)

func GetSix(input io.Reader) int {
	sum := 0

	numbers := make([][]string, 0)
	var operators []string

	operatorsRegex := regexp.MustCompile("[*-+-\\-]")
	numbersRegex := regexp.MustCompile("[0-9]+")

	scanner := bufio.NewScanner(input)
	for scanner.Scan() {
		text := scanner.Text()

		if operatorsRegex.MatchString(text) {
			operators = operatorsRegex.FindAllString(text, -1)
			break
		}

		numbersRow := numbersRegex.FindAllString(text, -1)
		numbers = append(numbers, numbersRow)
	}

	sizeLine := len(numbers[0])

	for i := 0; i < sizeLine; i++ {
		operator := operators[i]
		result := 0
		for j := 0; j < len(numbers); j++ {
			n, _ := strconv.Atoi(numbers[j][i])
			if j == 0 {
				result = n
				continue
			}

			switch operator {
			case "+":
				result += n
			case "-":
				result -= n
			case "*":
				result *= n
			}
		}
		sum += result
	}

	return sum
}
