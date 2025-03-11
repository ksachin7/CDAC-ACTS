#!/bin/bash

# 14. Write a shell script named "rename_files.sh" that renames all ".txt" files in the current directory by adding a timestamp to their filenames.

# Rename .txt files by adding timestamp
for file in *.txt; do
    if [ -f "$file" ]; then
        timestamp=$(date +%Y%m%d%H%M%S)
        mv "$file" "${file%.txt}_$timestamp.txt"
    fi
done
