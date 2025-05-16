# Use a specific version of OpenJDK for better reproducibility
FROM openjdk:11-jdk-slim

# Set the working directory
WORKDIR /app

# Create a lib directory
RUN mkdir /app/lib

# Copy the application code and the MySQL connector JAR
COPY . /app
COPY mysql-connector-java-8.0.15.jar /app/lib/

# Compile the Java files
RUN javac -cp /app:/app/lib/* *.java

# Set the command to run the application
CMD ["java", "-cp", "/app:/app/lib/*", "DbConnect"]
