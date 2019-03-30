# this script is called when the judge wants our compiler to compile a source file.
# print the compiled source, i.e. asm code, directly to stdout.
# don't print anything other to stdout.
# if you would like to print some debug information, please go to stderr.

java -Dfile.encoding=UTF-8 -classpath bin:lib/antlr-4.7.2-complete.jar main.java.Main