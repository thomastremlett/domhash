# Use RedHat as the base image
FROM registry.access.redhat.com/ubi8/ubi

# Install required packages
RUN yum update -y && \
    yum install -y java-1.8.0-openjdk && \
    yum clean all

# Set working directory
WORKDIR /app

# Copy the microservice JAR file into the container
COPY target/my-microservice.jar .

# Expose the port used by the microservice
EXPOSE 8080

# Start the microservice when the container starts
CMD ["java", "-jar", "domhash.jar"]
