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

	want := 3121910778619
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
		{"987654321111111", 987654321111},
		{"811111111111119", 811111111119},
		{"234234234234278", 434234234278},
		{"818181911112111", 888911112111},
	}

	for _, c := range cases {
		t.Run(fmt.Sprintf("Batteries in %v", c.input), func(t *testing.T) {
			got := getBank(c.input)

			if got != c.want {
				t.Errorf("got %v, want %v", got, c.want)
			}
		})
	}
}
