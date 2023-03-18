# DomHash API Microservice

This is a SpringBoot microservice that computes the DOMHASH of an XML input using Apache XML Security library.
Getting Started

## To get started with this project, follow the steps below:

    + Clone the repository to your local machine: git clone https://github.com/thomastremlett/domhash.git

    + Navigate to the project directory: cd domhash

#### Theres a docker file to build a docker container 
The container basically just runs /app/build/libs/init-0.0.1-SNAPSHOT.jar
``` 
docker build -t domhash .
docker run -p 8080:8080 domhash
```

use curl to send an api request
```
curl -X POST -H "Content-Type: application/json" -d '{"xml": "<root><message>Hello World!</message></root>"}' http://localhost:8080/domhash
```

#### The Main java magick
Located at domhash/app/main/java/TRACKTAG/init

    + Navigate to ../TRACKTAG/init/ 
    + Build the project using Gradle: ./gradlew build
    + Run the application: java -jar build/libs/domhash.jar
    + Send xml to http://localhost:8080/domhash

## API Endpoints
### POST /domhash

This endpoint receives an XML input in the request body and returns the computed DOMHASH as a response.
Request

    Method: POST
    URL: http://localhost:8080/domhash
    Headers:
        Content-Type: application/xml
    Body:

#### xml

```
<InputXml>
    <xmlContent>your_xml_content_here</xmlContent>
</InputXml>
```

Response

    Status Code: 200 (OK)
    Body:

#### xml

```
<DomHash>
    <hash>your_computed_domhash_here</hash>
</DomHash>
```