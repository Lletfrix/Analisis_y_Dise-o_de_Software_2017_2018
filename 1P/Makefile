JAVAC=javac
BUILD_DIR=build
JFLAGS=-d $(BUILD_DIR) -cp $(BUILD_DIR) -sourcepath $(SRC_DIR)
SRC_DIR=src
sources = $(wildcard $(SRC_DIR)/*.java)
classes = $(sources:.java=.class)

all: $(classes) doc

%.class : %.java
	$(JAVAC) $(JFLAGS) $<

.PHONY: doc
doc: $(sources)
	mkdir -p doc
	javadoc -d doc -author $(sources)
	
.PHONY: clean
clean :
	rm -rf $(BUILD_DIR)/*.class doc

