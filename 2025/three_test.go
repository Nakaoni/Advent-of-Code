package aoc

import (
	"fmt"
	"strings"
	"testing"
)

func TestStarThree(t *testing.T) {
	input := strings.NewReader(`987654321111111
811111111111119
234234234234278
818181911112111`)

	want := 357
	got := GetThree(input)

	if got != want {
		t.Errorf("got %d, want %d", got, want)
	}
}

func TestGetBatteries(t *testing.T) {
	cases := []struct {
		input string
		want  int
	}{
		{"987654321111111", 98},
		{"811111111111119", 89},
		{"234234234234278", 78},
		{"818181911112111", 92},
	}

	for _, c := range cases {
		t.Run(fmt.Sprintf("Batteriess in %v", c.input), func(t *testing.T) {
			got := getBank(c.input)

			if got != c.want {
				t.Errorf("got %v, want %v", got, c.want)
			}
		})
	}
}
