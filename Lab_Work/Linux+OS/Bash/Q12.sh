#!/bin/bash

# 12. Write a shell script named "backup.sh" that copies all files from the current directory to a backup directory named "backup_files" located in the user's home directory.

backup_dir="$HOME/backup_files"
mkdir -p "$backup_dir"

cp * "$backup_dir"

echo "All files have been backed up to $backup_dir."
