package main

import (
	"aoc"
	"fmt"
	"log"
	"os"
)

func main() {
	args := os.Args

	if len(args) < 2 {
		fmt.Printf("Usage: %s path/to/file", args[0])
	}

	filePath := args[1]

	f, err := os.Open(filePath)
	if err != nil {
		log.Fatalf("Unable to open file %q", filePath)
	}

	fmt.Println("Answer: ", aoc.GetTwo(f))
}
