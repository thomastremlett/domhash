package TRACKTAG.init;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class DomHashUtility {

    /**
     * Computes the DOMHASH of the input XML using SHA-256 algorithm.
     * Returns null if there is any error during the computation.
     */
    public static String computeDomHash(String xml) {
        try {
            // Parse the input XML into a Document object
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xml)));

            // Compute the SHA-256 hash of the DOM tree
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = messageDigest.digest(getBytes(document));

            // Convert the hash bytes to a hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            // Return the hex string as the computed DOMHASH
            return hexString.toString();
        } catch (Exception e) {
            // Handle any exceptions by returning null
            return null;
        }
    }

    // Define a private static method that returns a byte array representing the DOM tree of a given Document object.
    // This method takes a Document object as its parameter and throws an Exception if there is any error.
    private static byte[] getBytes(Document doc) throws Exception {
        // Create a new ByteArrayOutputStream object to hold the byte array.
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        // Create a new TransformerFactory object using the default implementation.
        TransformerFactory tf = TransformerFactory.newInstance();
        // Create a new Transformer object to transform the DOM tree to a byte array.
        Transformer transformer = tf.newTransformer();
        // Use the Transformer object to transform the DOM tree of the Document object to a byte array.
        // Pass the Document object to be transformed as a DOMSource object.
        // Pass the ByteArrayOutputStream object as a StreamResult object to hold the transformed byte array.
        transformer.transform(new DOMSource(doc), new StreamResult(bos));
        // Return the byte array from the ByteArrayOutputStream object.
        return bos.toByteArray();
    }
}
