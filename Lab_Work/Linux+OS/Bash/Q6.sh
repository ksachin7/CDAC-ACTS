#!/bin/bash

# 6. Write a shell script named `count_words.sh` that takes a filename as input and counts the number of words in that file.

file="word_file.txt"

for item in $(cat $file)
do
	echo $item
done

word=$(wc -w <$file)
echo $word
