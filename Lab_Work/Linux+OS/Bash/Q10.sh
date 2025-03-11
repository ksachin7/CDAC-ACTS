#!/bin/bash

<< COMMENT
10. Create a library of shell functions to do the followings:
	Function to concatenate 2 strings. Pass 2 strings as parameters to function.
	Function to find out the length of a given string, Pass string as a parameter to function.
	Function to compare the two strings. Pass 2 strings as parameters to function.
	Function to check if string is palindrome or not. Pass string as a parameter to function.
	Function to print given string in reverse order. Pass string as a parameter to function.
COMMENT

read -p "Enter a string: " str1
read -p "Enter another string: " str2
echo ""

concatenate_string(){
	echo "Concatinated string is : $str1$str2"
}

concatenate_string $str1 $str2

string_length(){
	echo "Lenght of string 1 : ${#1}"
}

string_length $str1

string_compare(){
	if [ "$str1" == "$str2" ]
	then
		echo "Strings are equal!"
	else
		echo "Strings are Differnt!"
	fi
}

string_compare

palindrome() {
    rev=$(echo "$1" | rev)
    if [ "$1" == "$rev" ]; then
        echo "$1 is a palindrome!"
    else
        echo "$1 is not a palindrome!"
    fi
}

palindrome $str1

reverse() {
    echo "$1" | rev
}

echo -n "The reverse of $str1 is: "; reverse $str1

