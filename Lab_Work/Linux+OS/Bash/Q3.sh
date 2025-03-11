#!/bin/bash

# 3. Write a shell script named `even_odd.sh` that takes a number as input and prints whether it is even or odd.

read -p "Enter a number : " n

if [ $((n%2)) -eq 0 ]
then
	echo "The number is even."
else
	echo "The number is odd."
fi
