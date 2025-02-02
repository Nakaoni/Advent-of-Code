CLASS=AdventOfCodeApplication
CLASS_PATH=src/main/java
TEST_CLASS_PATH=src/test/java
PACKAGE=fr.nakaoni.aoc
TARGET_DIR=./target/classes
LIB_DIR=./lib/*
VERSION=17

all: run

.PHONY: build build_test run clean test

build:
	javac -d $(TARGET_DIR) --target $(VERSION) $(CLASS_PATH)/fr/nakaoni/aoc/DayResponse.java
	javac -d $(TARGET_DIR) --target $(VERSION) -cp $(TARGET_DIR) $(CLASS_PATH)/fr/nakaoni/aoc/**/*.java
	javac -d $(TARGET_DIR) --target $(VERSION) -cp $(TARGET_DIR) $(CLASS_PATH)/fr/nakaoni/aoc/AdventOfCodeApplication.java

run: build
	java -cp $(TARGET_DIR) $(PACKAGE).$(CLASS)

build_test: build
	javac -d $(TARGET_DIR) --target $(VERSION) -cp "$(TARGET_DIR);$(LIB_DIR)" $(TEST_CLASS_PATH)/fr/nakaoni/aoc/*.java
	javac -d $(TARGET_DIR) --target $(VERSION) -cp "$(TARGET_DIR);$(LIB_DIR)" $(TEST_CLASS_PATH)/fr/nakaoni/aoc/**/*.java

test: build build_test
	java -cp "$(TARGET_DIR);$(LIB_DIR)" org.junit.platform.console.ConsoleLauncher execute --scan-classpath $(TARGET_DIR)
