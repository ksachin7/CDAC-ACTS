#!/bin/sh

# Read the upper limit from the user
read -p "Enter a number: " n

echo "Prime numbers up to $n are:"

i=2
while [ "$i" -le "$n" ]; do
    is_prime=1
    j=2
    while [ "$j" -lt "$i" ]; do
        if [ $((i % j)) -eq 0 ]; then
            is_prime=0
            break
        fi
        j=$((j + 1))
    done
    if [ "$is_prime" -eq 1 ]; then
        echo "$i"
    fi
    i=$((i + 1))
done
