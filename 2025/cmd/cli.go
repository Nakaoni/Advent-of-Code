package main

import (
	"aoc"
	"bytes"
	"embed"
	"errors"
	"fmt"
	"io"
	"log"
	"os"
	"strings"
)

//go:embed inputs/*
var inputs embed.FS

var DayList = map[string]func(io.Reader) int{
	strings.ToLower(aoc.ONE):   aoc.GetOne,
	strings.ToLower(aoc.TWO):   aoc.GetTwo,
	strings.ToLower(aoc.THREE): aoc.GetThree,
	strings.ToLower(aoc.FOUR):  aoc.GetFour,
	strings.ToLower(aoc.FIVE):  aoc.GetFive,
}

func main() {
	args := os.Args

	if len(args) < 2 {
		printHelp(args[0])
		return
	}

	day := args[1]
	dayFile := fmt.Sprintf("inputs/%s.txt", day)

	data, err := inputs.ReadFile(dayFile)
	if err != nil {
		log.Fatalf("Unable to open file %q", dayFile)
	}

	fn, err := getPuzzleAnswer(day)
	if err != nil {
		fmt.Println(err)
	}
	fmt.Println("Answer: ", fn(bytes.NewReader(data)))
}

func getPuzzleAnswer(day string) (func(io.Reader) int, error) {
	fn, ok := DayList[day]
	if !ok {
		return nil, errors.New("Unsupported day")
	}
	return fn, nil
}

func printHelp(bin string) {
	fmt.Printf("Usage: %s [day]\n\n", bin)

	fmt.Print("Available days: ")

	keys := make([]string, 0)
	for k := range DayList {
		keys = append(keys, k)
	}
	fmt.Printf("%s\n\n", strings.Join(keys, ", "))

	fmt.Printf("Example:\n%s one\n", bin)
}
