#!/bin/bash

# 15. Create a shell script named "directory_size.sh" that takes a directory name as an argument and calculates the total size of all files within that directory (including subdirectories) in megabytes.

read -p "Enter directory name: " dir

# Calculate directory size in MB
if [ -d "$dir" ]; then
    size=$(du -sh "$dir" | cut -f1)
    echo "The size of the directory $dir is $size."
else
    echo "Directory does not exist."
fi
