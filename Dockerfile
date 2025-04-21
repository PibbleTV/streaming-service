# Use Oracle Linux 8 as the base image
FROM oraclelinux:8

# Install OpenJDK
RUN dnf install -y java-17-openjdk

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