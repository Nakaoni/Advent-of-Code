# Advent-of-Code

Repository containing the history of Advent of Code journey

## 2024

The goal is to get familiar with Java. <br>
I have never really completely deep dive into it.
I will take this AoC 2024 opportunity to, at least, use and (re)learn Java.

According to New Relic's annual State of Java Ecosystem report, the version 17 is the most used, therefore, I will code in Java 17.

Stack:
- Java version: 17
- Build system: Makefile (I will not use Maven or Gradle as I want to learn from scratch first)
- Testing framework: jUnit5

### Settings

- Classpath:
    - src/main/java
    - src/test/java

### Commands

> For Windows, replace class path' separator is ";" instead of ":"

#### See the responses

```sh
make
```

or


```sh
make build
make run
```

#### Run the tests


```sh
make build_test
make test
```

## 2025

This year, let's continue to work with GO !

#### See the specific response

> [!Note]
> Part 1 is overrided by part 2. If you want to see the part 1 solution, refer to the commit

```sh
go build -o aoc cmd/cli.go
./aoc [day]
```

#### Run the tests

```sh
go test aoc
```