# Use OpenJDK base image
FROM eclipse-temurin:21-jdk-jammy

# Set working directory
WORKDIR /app

# Copy jar file into image
COPY target/gateway-service.jar gateway-service.jar

# Expose port (change if needed)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "gateway-service.jar"]
