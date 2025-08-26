# Use OpenJDK base image
FROM eclipse-temurin:21-jdk-jammy

# Set working directory
WORKDIR /app

# Copy jar file into image
COPY target/eureka-service-discovery.jar eureka-service-discovery.jar

# Expose port (change if needed)
EXPOSE 8761

# Run the jar file
ENTRYPOINT ["java", "-jar", "eureka-service-discovery.jar"]
