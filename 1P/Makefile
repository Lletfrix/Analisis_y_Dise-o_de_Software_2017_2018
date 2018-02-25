JAVAC=javac
BUILD_DIR=build
ZIP_NAME=GR2202_RafaelSergio
DIST_PATH=./*
JFLAGS=-d $(BUILD_DIR) -cp $(BUILD_DIR) -sourcepath $(SRC_DIR)
SRC_DIR=src
sources = $(wildcard $(SRC_DIR)/*.java)
classes = $(sources:.java=.class)

build: $(classes)

all: build doc dist

%.class : %.java
	$(JAVAC) $(JFLAGS) $<

.PHONY: doc
doc: $(sources)
	mkdir -p doc
	javadoc -d doc -author $(sources)

.PHONY: dist
dist:
	zip -r $(ZIP_NAME).zip $(DIST_PATH)
.PHONY: clean
clean :
	rm -rf $(BUILD_DIR)/*.class doc *.zip
