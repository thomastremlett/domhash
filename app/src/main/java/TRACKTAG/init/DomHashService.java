// Declare the package for the DomHashService class
package TRACKTAG.init;

// Import the required Spring classes
import org.springframework.stereotype.Service;

// Declare the DomHashService class as a service
@Service
public class DomHashService {

    // Define a method that computes the DOMHASH for a given InputXml object
    public String computeDomHash(InputXml inputXml) {
        // Extract the XML string from the InputXml object
        String xml = inputXml.getXml();
        // Use the DomHashUtility to compute the DOMHASH for the XML string
        return DomHashUtility.computeDomHash(xml);
    }

}
