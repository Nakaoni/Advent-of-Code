package aoc

import (
	"strings"
	"testing"
)

func TestStarFive(t *testing.T) {
	input := strings.NewReader(`3-5
10-14
16-20
12-18

1
5
8
11
17
32`)

	want := 14
	got := GetFive(input)

	if got != want {
		t.Errorf("got %d, want %d", got, want)
	}
}
