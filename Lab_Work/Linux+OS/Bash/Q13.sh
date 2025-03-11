#!/bin/bash

# 13. Create a shell script named "file_count.sh" that takes a directory name as an argument and displays the count of files in that directory.

read -p "Enter directory name: " dir

# Count the files in the directory
if [ -d "$dir" ]; then
    file_count=$(ls -1q "$dir" | wc -l)
    echo "There are $file_count files in the directory $dir."
else
    echo "Directory does not exist."
fi
