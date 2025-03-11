#!/bin/bash

# 7. Write a shell script named `generate_password.sh` that takes a length as input and generates a random password of that length.

# Set the locale to avoid tr errors
export LC_ALL=C

read -p "Enter the length of the password: " length

# Generate a random password
password=$(tr -dc A-Za-z0-9 </dev/urandom | head -c $length)

# Generate a random password using openssl (if available)
#password=$(openssl rand -base64 48 | tr -dc 'A-Za-z0-9' | head -c $length)

echo "Generated password: $password"
