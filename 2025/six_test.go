package aoc

import (
	"strings"
	"testing"
)

func TestStarSix(t *testing.T) {
	input := strings.NewReader(`123 328  51 64 
 45 64  387 23 
  6 98  215 314
*   +   *   +  `)

	want := 4277556
	got := GetSix(input)

	if got != want {
		t.Errorf("got %d, want %d", got, want)
	}
}
