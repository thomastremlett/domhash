/**
    This is the controller class for the DOMHASH REST API endpoint.
    It receives HTTP requests and returns the computed DOMHASH as a response.
*/

package TRACKTAG.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DomHashController {

    // Inject the DomHashService bean into the controller
    @Autowired
    private DomHashService domHashService;

    /**
     * This method receives HTTP POST requests with an InputXml object as the request body,
     * calls the DomHashService to compute the DOMHASH, and returns the computed DOMHASH
     * as a response with HTTP status code 200 (OK).
     * 
     * @param inputXml - the InputXml object containing the XML content to compute the DOMHASH of
     * @return - the computed DOMHASH as a String in a ResponseEntity object with HTTP status code 200 (OK)
     */
    
    @PostMapping("/domhash")
    public ResponseEntity<String> getDomHash(@RequestBody InputXml inputXml) {
        
        // Call the DomHashService to compute the DOMHASH of the InputXml object
        String domHash = domHashService.computeDomHash(inputXml);

        // Return the computed DOMHASH as a response with HTTP status code 200 (OK)
        return new ResponseEntity<>(domHash, HttpStatus.OK);
    }



    // @PostMapping("/inputxml")
    // @PutMapping("/inputxml")
    // @DeleteMapping("/inputxml/{id}")

}
