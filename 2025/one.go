package aoc

import (
	"bufio"
	"io"
	"log"
	"strconv"
	"strings"
)

const (
	LEFT         = "L"
	RIGHT        = "R"
	LEFT_BORDER  = 0
	RIGHT_BORDER = 99
)

func GetOne(r io.Reader) int {
	sum := 0
	currentPosition := 50

	scanner := bufio.NewScanner(r)
	for scanner.Scan() {
		text := scanner.Text()
		direction, distance := getInstruction(text)
		newPosition, count := computePosition(currentPosition, direction, distance)

		currentPosition = newPosition
		sum += count
	}

	return sum
}

func getInstruction(s string) (direction string, distance int) {
	if strings.HasPrefix(s, LEFT) {
		direction = LEFT
	} else {
		direction = RIGHT
	}

	distanceAsString, ok := strings.CutPrefix(s, direction)
	if !ok {
		log.Fatalf("Error Cutting prefix %q in string %q\n", direction, s)
	}

	distance, err := strconv.Atoi(distanceAsString)
	if err != nil {
		log.Fatalf("Error converting string to int: %v", distanceAsString)
	}

	return direction, distance
}

func computePosition(currentPosition int, direction string, distance int) (newPosition, count int) {
	remaining := distance

	for remaining > 0 {
		if direction == LEFT {
			currentPosition--
		} else {
			currentPosition++
		}

		if currentPosition == LEFT_BORDER-1 {
			currentPosition = RIGHT_BORDER
		}

		if currentPosition == RIGHT_BORDER+1 {
			currentPosition = LEFT_BORDER
		}

		if currentPosition == LEFT_BORDER {
			count++
		}

		remaining--
	}

	return currentPosition, count
}
