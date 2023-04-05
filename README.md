# DOMHASH
QUT Capstone -- Tracktag


# XML Hasher Microservice

This repository contains the source code for a Java Spring Boot microservice designed to process XML files, perform hashing and comparison operations. The microservice is containerized using Podman for easier deployment and management.

## Architecture

The architecture is organized into separate folders for controllers, models, and services, allowing for clean organization and separation of concerns.

- `controllers`: Contains the REST API controllers for handling incoming requests.
- `models`: Contains the data models and data transfer objects (DTOs) used by the application.
- `services`: Contains the business logic and services for processing XML files, hashing, and comparison operations.

## Requirements

- Java 17?
- Maven
- Podman/Docker

## Modifying code

```sh
# Get current repo
git clone https://github.com/AnimatedSwine37/domhash-microservice.git

# Make a seperate copy of the code to work on
git branch my_branch

# Work on your copy of the code
git checkout my_branch

# Complete your feature

# Add your changes
git add .

# Comment on your changes
git commit -m "Changes:"

# Send your changes 
git push origin 

# Get up to date with everyone elses changes
git pull origin my_branch
```

## Running the service



1. Clone the repository.

```bash
git clone https://github.com/AnimatedSwine37/domhash-microservice.git
```

2.  Build the project.

```bash
cd DOMHASH
mvn clean install 
```

3.  Build the Podman container.

```bash
podman build -t DOMHASH .
```

4.  Run the container.

bash

```bash
podman run -p 8080:8080 DOMHASH
```



## Overview
```
L-- DomHash
|   L-- src
|   |   L-- main
|   |   |   L-- java
|   |   |   |   L-- com.hitachi.domhash
|   |   |   |       L-- controllers
|   |   |   |       |    L-- 
|   |   |   |       L-- models
|   |   |   |       |    L-- 
|   |   |   |       L-- services
|   |   |   |       |    L-- 
|   |   |   L-- resources
|   |   L-- test
|   L-- Dockerfile
|   L-- README.md
```