SRC=AdventOfCodeApplication.java
CLASS=AdventOfCodeApplication
CLASS_PATH=main/fr/nakaoni/aoc
TEST_CLASS_PATH=test/fr/nakaoni/aoc
PACKAGE=fr.nakaoni.aoc
VERSION=17

all: run

.PHONY: build run clean test

build:
	javac -d . --target $(VERSION) $(CLASS_PATH)/$(SRC)

run: build
	java --class-path . $(PACKAGE).$(CLASS)
