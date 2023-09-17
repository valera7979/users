# Use a base image with Java installed
FROM openjdk:11-jdk
VOLUME /tmp

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build context into the container
COPY build/libs/user-manager-0.0.1.jar app.jar

# Copy the application.yaml file into the container
COPY src/main/resources/application.yaml application.yaml
COPY src/main/resources/data.sql data.sql

# Set the entrypoint command to run the Spring Boot application
#ENTRYPOINT ["java","-jar","/app/app.jar"]
#docker run -p 9001:9001 users-app
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app/app.jar ${0} ${@}"]
#docker run -p 9001:9001 users-app --server.port=9001