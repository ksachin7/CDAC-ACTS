#!/bin/bash

read -p "Enter a no.: " n
for((i=0; i<n; i++))
do
	for((j=0; j<i+1; j++))
	do
		echo -n "*"
	done 
	echo " "
done
