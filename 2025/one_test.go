package aoc

import (
	"strings"
	"testing"
)

func TestStarOne(t *testing.T) {
	input := strings.NewReader(`L68
L30
R48
L5
R60
L55
L1
L99
R14
L82`)

	want := 3
	got := GetPassword(input)

	if got != want {
		t.Errorf("got %d, want %d", got, want)
	}
}
