# Use OpenJDK base image
FROM eclipse-temurin:21-jdk-jammy

# Set working directory
WORKDIR /app

# Copy jar file into image
COPY target/configuration-server.jar configuration-server.jar

# Expose port (change if needed)
EXPOSE 8888

# Run the jar file
ENTRYPOINT ["java", "-jar", "configuration-server.jar"]
