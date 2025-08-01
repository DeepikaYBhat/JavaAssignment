

# Use the latest OpenJDK base image
FROM openjdk:latest

# Expose port 5432
EXPOSE 5432

# Argument to specify the JAR file (with default path)
ARG JAR_FILE=target/*.jar

# Copy the JAR file into the image as app.jar
COPY ${JAR_FILE} app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
