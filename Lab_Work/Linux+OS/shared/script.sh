#!/bin/bash


<<comments
multiline
kjdshglkj
comments

#comment

str="Hello World!"
echo "$str"


for i in 1 2 3 4 5
	do
		echo "$i"
	done

for j in a b c d
	do
		echo "$j"
	done

echo "Enter value of x"

read x

echo "$x"

# echo "Enter a no"
# read -p "Enter a no. " n
<<comments
for(( r=0; i<$n; i++ ))
do
	for(( i=0; i<$r; i++ ))
	do
		echo "*"
	done
done
comments
# Arithmetic Operations

read -p "Enter no. 1: " num1
read -p "Enter no. 2: " num2
#let sum=$num1+$num2
sum=$((num1+num2))
echo "Sum is $sum"

