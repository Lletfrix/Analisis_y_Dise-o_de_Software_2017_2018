JAVAC=javac
BUILD_DIR=build
JFLAGS=-d $(BUILD_DIR) -cp $(BUILD_DIR)
SRC_DIR=src
sources = $(wildcard $(SRC_DIR)/*.java)
classes = $(sources:.java=.class)

all: $(classes)

clean :
	rm -f $(BUILD_DIR)/*.class

.PHONY: doc
doc:
	javadoc -d doc -author $(sources)
	
%.class : %.java
	$(JAVAC) $(JFLAGS) $<
