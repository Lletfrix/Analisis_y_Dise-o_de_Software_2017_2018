JAVAC=javac
BUILD_DIR=build
SRC_DIR=src
sources = $(wildcard $(SRC_DIR)/*.java)
classes = $(sources:.java=.class)

all: $(classes)

clean :
	rm -f $(BUILD_DIR)/*.class

%.class : %.java
	$(JAVAC) -d $(BUILD_DIR) $<
