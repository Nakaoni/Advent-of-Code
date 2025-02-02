CLASS=AdventOfCodeApplication
CLASS_PATH=src/main/java
TEST_CLASS_PATH=src/test/java
PACKAGE_AS_PATH=fr/nakaoni/aoc
PACKAGE=fr.nakaoni.aoc
TARGET_DIR=./target/classes
LIB_DIR=./lib/*
VERSION=17
OPTIONS=-Xlint

all: run

.PHONY: build build_test run clean test

build:
	javac $(OPTIONS) -d $(TARGET_DIR) --target $(VERSION) $(CLASS_PATH)/$(PACKAGE_AS_PATH)/DayResponse.java
	javac $(OPTIONS) -d $(TARGET_DIR) --target $(VERSION) -cp $(TARGET_DIR) $(CLASS_PATH)/$(PACKAGE_AS_PATH)/**/*.java
	javac $(OPTIONS) -d $(TARGET_DIR) --target $(VERSION) -cp $(TARGET_DIR) $(CLASS_PATH)/$(PACKAGE_AS_PATH)/AdventOfCodeApplication.java

run: build
	java -cp $(TARGET_DIR) $(PACKAGE).$(CLASS)

build_test: build
	javac $(OPTIONS) -d $(TARGET_DIR) --target $(VERSION) -cp "$(TARGET_DIR):$(LIB_DIR)" $(TEST_CLASS_PATH)/$(PACKAGE_AS_PATH)/*.java
	javac $(OPTIONS) -d $(TARGET_DIR) --target $(VERSION) -cp "$(TARGET_DIR):$(LIB_DIR)" $(TEST_CLASS_PATH)/$(PACKAGE_AS_PATH)/**/*.java

test: build build_test
	java -cp "$(TARGET_DIR):$(LIB_DIR)" org.junit.platform.console.ConsoleLauncher execute --scan-classpath $(TARGET_DIR)
