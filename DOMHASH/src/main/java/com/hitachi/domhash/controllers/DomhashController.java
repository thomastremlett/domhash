// This is the package name that contains the DomhashController class
package com.hitachi.domhash.controllers;

// Import the required classes from the Spring framework
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hitachi.domhash.services.DomhashGenerator;

// The @RestController annotation indicates that this class is a RESTful controller.
// It is responsible for processing incoming HTTP requests and returning responses.
@RestController
public class DomhashController {

    // The @PostMapping annotation indicates that this method should handle HTTP POST requests 
    // sent to the "/domhash" endpoint. The consumes attribute specifies that the controller 
    // can only handle requests with a content type of "application/xml".
    @PostMapping(value = "/domhash", consumes = {MediaType.APPLICATION_XML_VALUE})
    public static String domhash(@RequestBody byte[] xml) {
        try {
            // Call the generateDomHash method from DomhashGenerator class to calculate the hash
            String hash = DomhashGenerator.generateDomHash(xml);
            return hash; // Return the calculated hash
        } catch(Exception e) {
            // If an exception is thrown during the calculation of the hash, print the stack trace 
            // and return an error message to the client
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
