# Use Red Hat Universal Base Image as base image
FROM registry.access.redhat.com/ubi8/ubi-minimal:8.5

# Install Java 17 and other dependencies
RUN microdnf install -y java-17-openjdk-headless && \
    microdnf clean all

# Set the working directory
WORKDIR /srv/

# Copy the microservice JAR file to the container
COPY ./app/build/libs/init-0.0.1-SNAPSHOT.jar .

# Expose the port that the microservice will run on
EXPOSE 8080

# Start the microservice when the container starts
CMD ["java", "-jar", "/srv/init-0.0.1-SNAPSHOT.jar"]
