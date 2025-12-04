package aoc

import (
	"fmt"
	"reflect"
	"strings"
	"testing"
)

func TestStarTwo(t *testing.T) {
	input := strings.NewReader("11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124")

	want := 1227775554
	got := GetTwo(input)

	if got != want {
		t.Errorf("got %d, want %d", got, want)
	}
}

func TestGetInvalidIds(t *testing.T) {
	cases := []struct {
		input string
		want  []int
	}{
		{"11-22", []int{11, 22}},
		{"95-115", []int{99}},
		{"998-1012", []int{1010}},
		{"1188511880-1188511890", []int{1188511885}},
		{"222220-222224", []int{222222}},
		{"1698522-1698528", []int{}},
		{"446443-446449", []int{446446}},
		{"38593856-38593862", []int{38593859}},
		{"565653-565659", []int{}},
	}

	for _, c := range cases {
		t.Run(fmt.Sprintf("Invalids IDs in %v", c.input), func(t *testing.T) {
			got := getInvalidIds(c.input)

			if !reflect.DeepEqual(got, c.want) {
				t.Errorf("got %v, want %v", got, c.want)
			}
		})
	}
}
