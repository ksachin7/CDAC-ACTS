#!/bin/bash

# 9. Write a script that takes a command line argument and reports on its file type (regular file, directory file, etc.). For more than one argument generate error message. 

if [ "$#" -eq 0 ] 
then
	echo "Usage: $0 [file1] [file2]..."
	exit 1
fi

for file in "$@"
do
	if [ ! -e "$file" ]
	then
		echo "$file: nos uch file or directory."
	elif [ -f "$file" ]
	then
		echo "$file : regular

	 file"
	elif [ -d "$file" ]
	then
		echo "$file: Directory"
	else 
		echo "Unknown file/directory!"
	fi
done
