FROM openjdk:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY build/libs/streaming_service-0.0.1-SNAPSHOT.jar streaming_service.jar

# Expose the application's port
EXPOSE 8085

# Run the application
ENTRYPOINT ["java", "-jar", "streaming_service.jar"]

#docker build -t ghcr.io/pibbletv/pibbletv-streaming-service:latest -f Dockerfile .
#docker run -d --name -p 8085:8085 ghcr.io/pibbletv/pibbletv-streaming-service:latest