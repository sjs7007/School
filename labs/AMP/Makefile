compile: 
	javac $(file).java

run:
	cp $(file).java combinedText/$(file).txt #copy java program to text file
	cat ../common/oBegins.txt >> combinedText/$(file).txt  #append output begins string 
	java $(file) | tee -a combinedText/$(file).txt #append output to above text file
	cat ../common/end.txt >> combinedText/$(file).txt #append dashes which signify end of output

all: compile run clean

clean: 
	rm *.class