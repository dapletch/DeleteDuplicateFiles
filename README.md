# DeleteDuplicateFiles
DISCLAIMER:
This program uses a bash shell script to run an executable jar file. If you are using Windows, you must have either Cygwin, or MobaXterm installed to use said program in the way it was intended.

DESCRIPTION:
This program is called from the getFileListRunJavaDeleteDuplicates.bsh script which generates a text file containing a list of all the files located in a given directory. Once the list has been generated the program then reads in the file, and parses it. After the file has been parsed the program then submits the list to an H2 embedded database, and orders the list by the file name(s). The program then deletes the files in the list accordingly.
