# Use a base image with Java installed
FROM openjdk:11-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build context into the container
COPY build/libs/user-manager-0.0.1.jar app.jar

# Copy the application.yaml file into the container
COPY src/main/resources/application.yaml application.yaml
COPY src/main/resources/data.sql data.sql

# Expose the port that the Spring Boot application listens on
EXPOSE 51108

# Set the entrypoint command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]