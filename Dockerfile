# Use the official OpenJDK image as a base image
FROM openjdk:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy only the necessary source files to the container
COPY ./src ./src

# Compile the Java source files
RUN javac -d . src/*.java

# Define the entry point for the application
CMD ["java", "-cp", ".", "Sistema"]
