#!/bin/bash

# 8. Write a shell script named `simple_calculator.sh` that presents a menu to the user with options for addition, subtraction, multiplication, and division, and performs the selected operation on two numbers entered by the user.

# menu for calculator
echo "Select operation:"
echo "+. Addition"
echo "-. Subtraction"
echo "*. Multiplication"
echo "/. Division"
echo -n " "

read -p "Enter Operartor : " choice

read -p "Enter first number : " num1
read -p "Enter second number : " num2

case $choice in
	"+") echo "Addition is :  $(($num1+$num2))";;
	"-") echo "Substraction is :  $(($num1-$num2))";;
	"/") echo "Division is :  $(($num1/$num2))";;
	"*") echo "Multiplication is : $(($num1*$num2))";;
	*) echo "Invalid input!";;
esac
