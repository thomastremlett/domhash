// Declare the package for the InputXml class
package TRACKTAG.init;

// Declare the InputXml class
public class InputXml {

    // Declare a private instance variable to store the XML string
    private String xml;

    // Declare a default constructor for the InputXml class
    public InputXml() {
        // Initialize the xml variable to an empty string
        this.xml = "";
    }

    // Declare a parameterized constructor for the InputXml class that takes an XML string as a parameter
    public InputXml(String xml) {
        // Initialize the xml variable with the given XML string
        this.xml = xml;
    }

    // Declare a getter method to return the XML string
    public String getXml() {
        return xml;
    }

    // Declare a setter method to set the XML string
    public void setXml(String xml) {
        this.xml = xml;
    }
}
