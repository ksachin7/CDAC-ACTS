#!/bin/bash

<< COMMENT
11.Add some student records in the “student” file manually. The fields to be considered are “RollNo”, “Name”, “Marks_Hindi”, “Marks_Maths”, “Marks_Physics”. 
Write a script which does the following a	If the roll number already exists, then store the record and the following message 
“roll number exists” in a log file “log1”.
	b	If the marks in the subjects is not in the range of 1 – 99 then store such a record followed by a message “marks out of range” in “log1”
	c	If the data is valid, the calculate total, percentage, grade and display on the terminal

COMMENT

# student details
read -p "Enter RollNo: " rollno
read -p "Enter Name: " name
read -p "Enter Marks (Hindi, Maths, Physics): " marks_hindi marks_maths marks_physics

# Check if roll number exists and validate marks
if grep -q "$rollno" student.txt; then
    echo "$rollno exists" >> log1
elif [ $marks_hindi -lt 1 ] || [ $marks_hindi -gt 99 ] || [ $marks_maths -lt 1 ] || [ $marks_maths -gt 99 ] || [ $marks_physics -lt 1 ] || [ $marks_physics -gt 99 ]; then
    echo "$rollno - Marks out of range" >> log1
else
    total=$((marks_hindi + marks_maths + marks_physics))
    percentage=$((total / 3))
    if [ $percentage -ge 60 ]; then
        grade="A"
    elif [ $percentage -ge 50 ]; then
        grade="B"
    elif [ $percentage -ge 40 ]; then
        grade="C"
    else
        grade="F"
    fi
    echo "Total: $total, Percentage: $percentage%, Grade: $grade"
    echo "$rollno,$name,$marks_hindi,$marks_maths,$marks_physics,$total,$percentage,$grade" >> student.txt
fi
