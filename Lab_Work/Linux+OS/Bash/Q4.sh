#!/bin/bash

# 4. Write a shell script named `sum_numbers.sh` that takes a number as input and calculates the sum of all numbers from 1 to that number.

# echo "Enter an number: "
read -p "Enter a number: " n
sum=0;

for(( i=1; i<=n; i++ ))
do
	 sum=$((sum+i))
done

echo "The sum of numbers from 0 to $n is : $sum"
