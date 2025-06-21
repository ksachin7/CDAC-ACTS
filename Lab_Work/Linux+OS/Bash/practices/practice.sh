#!/bin/bash

echo "Listing all files (excluding directories) in home directory, including hidden files:"

find ~ -maxdepth 1 -type f -print > home_files.txt
# find: Used to search for files
# ~: Refers to the home directory
# -maxdepth 1: Ensures it doesn’t look into subdirectories
# -type f: Limits the output to regular files only
# This will include hidden files as well (files starting with .).
# to overwrite(create the file if it doesn’t exist) > 
# to append(create the file if it doesn’t exist) >> 

# Print all process PPID, PID, and process name
# ps -eo ppid, pid, comm >> processes.txt
# ps -Ao ppid,pid,comm > mac_processes.txt

# -e: Select all processes
# -o: Specify output format
# ppid: Parent Process ID
# pid: Process ID
# comm: Command name (executable name)


# Copy all .conf files from /etc to the home directory
# cp /etc/*.conf ~/

# TO copy .conf files recursively from subdirectories as well
# find /etc -type f -name "*.conf" -exec cp {} ~/ \;


# search for the word "apple" in a file named "fruits.txt"?
grep -i "apple" fruits.txt  # case sensitive
grep -n "apple" fruits.txt  # with line number
grep -c "apple" fruits.txt  # count matches
