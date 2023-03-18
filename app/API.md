    POST request to /hash with a Person object in the request body:

json

{
  "name": "John Doe",
  "age": 30
}

This should return the SHA-256 hash of the XML representation of the Person object.

    POST request to /hash with an empty Person object in the request body:

json

{}

This should return the SHA-256 hash of the XML representation of the empty Person object.

    POST request to /hash with a malformed XML payload:

xml

<person>
  <name>John Doe</name>
  <age>30</age>
</person>

This should throw a 400 Bad Request error, since the payload is not valid XML.

    GET request to /hash:

This should throw a 405 Method Not Allowed error, since the /hash endpoint only accepts POST requests.

    POST request to an endpoint that doesn't exist:

This should throw a 404 Not Found error, since the requested endpoint does not exist.