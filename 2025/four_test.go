package aoc

import (
	"strings"
	"testing"
)

func TestStarFour(t *testing.T) {
	input := strings.NewReader(`..@@.@@@@.
@@@.@.@.@@
@@@@@.@.@@
@.@@@@..@.
@@.@@@@.@@
.@@@@@@@.@
.@.@.@.@@@
@.@@@.@@@@
.@@@@@@@@.
@.@.@@@.@.`)

	want := 13
	got := GetFour(input)

	if got != want {
		t.Errorf("got %d, want %d", got, want)
	}
}
