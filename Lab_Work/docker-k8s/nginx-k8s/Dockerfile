# Use a base image with JDK
FROM openjdk:17

# Set working directory inside container
WORKDIR /app

# Copy source code
COPY Sum.java .

# Compile Java program
RUN javac Sum.java

# Run the program
CMD ["java", "Sum"]
