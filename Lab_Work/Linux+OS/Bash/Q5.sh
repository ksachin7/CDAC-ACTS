#!/bin/bash

# 5. Write a shell script named `factorial_recursive.sh` that takes a number as input and calculates its factorial using recursion.

factorial() {
    if [ $1 -le 1 ]; then
        echo 1
    else
        prev=$(factorial $(($1 - 1)))
        echo $(($1 * $prev))
    fi
}

read -p "Enter a number: " num

result=$(factorial $num)
echo "Factorial of $num is $result."

