# Use Oracle Linux 8 as the base image
FROM oraclelinux:8

# Install OpenJDK
RUN dnf install -y java-17-openjdk

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file into the container
COPY build/libs/donations_service-0.0.1-SNAPSHOT.jar donations_service.jar

# Expose the application's port
EXPOSE 8084

# Run the application
ENTRYPOINT ["java", "-jar", "donations_service.jar"]

#docker build -t ghcr.io/pibbletv/pibbletv-donations-service:latest -f Dockerfile .
#docker run -d --name ghcr.io/pibbletv/pibbletv-donations-service:latest -p 8084:8084 follows_service