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

func main() {
	args := os.Args

	if len(args) < 2 {
		bin := args[0]
		fmt.Printf("Usage: %s [day]\n", bin)
		fmt.Printf("Example: %s one\n", bin)
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
	var fn func(io.Reader) int

	switch strings.ToUpper(day) {
	case aoc.ONE:
		fn = aoc.GetOne
	case aoc.TWO:
		fn = aoc.GetTwo
	default:
		return nil, errors.New("Unsupported day")
	}

	return fn, nil
}
