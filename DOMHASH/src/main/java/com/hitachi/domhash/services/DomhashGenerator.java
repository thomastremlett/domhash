// This is the package name that contains the DomhashGenerator class
package com.hitachi.domhash.services;

// Import the required classes from the Java and Axiom libraries
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMException;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.OMText;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.om.util.DigestGenerator;
import org.apache.axiom.om.util.StAXParserConfiguration;
import org.apache.commons.codec.binary.Hex;

public class DomhashGenerator {

    /**
     * Generate a DOMHASH string in hex format from an XML document
     * 
     * @param xml An XML document as an array of bytes
     * @return The DOMHASH of the XML document as a string
     * @throws FactoryConfigurationError
     * @throws XMLStreamException
     * @throws IOException
     * @throws OMException
     */
    public static String generateDomHash(byte[] xml)
            throws IOException, OMException, XMLStreamException, FactoryConfigurationError {
        // Create a byte array input stream to read the XML document as bytes
        ByteArrayInputStream in = new ByteArrayInputStream(xml);

        // Use Axiom's OMXMLBuilderFactory to build the OMElement tree from the XML document
        OMElement root = OMXMLBuilderFactory.createOMBuilder(StAXParserConfiguration.COALESCING, in)
                .getDocumentElement();

        // Remove empty text nodes from the OMElement tree
        removeEmptyTextNodes(root);

        // Generate the SHA1 digest of the OMElement tree using Axiom's DigestGenerator
        DigestGenerator digestGenerator = new DigestGenerator();
        byte[] digest = digestGenerator.getDigest(root, DigestGenerator.sha1DigestAlgorithm);

        // Close the input stream
        in.close();

        // Return the hex-encoded digest as a string
        return Hex.encodeHexString(digest);
    }

    /**
     * Remove empty text nodes from an OMElement tree so the DOMHASH of the tree is consistent
     * 
     * @param node The root node of the OMElement tree when initially called, when recursively called it is a child node
     */
    private static void removeEmptyTextNodes(OMNode node) {
        if (node == null) {
            return;
        }

        if (node instanceof OMElement) {
            OMElement element = (OMElement) node;

            // Iterate over the child nodes of the element
            Iterator<OMNode> children = element.getChildren();
            while (children.hasNext()) {
                OMNode child = children.next();
                if (child instanceof OMText) {
                    // If the child is an empty text node, remove it
                    if (((OMText) child).getText().isBlank())
                        children.remove();
                } else {
                    // Recursively remove empty text nodes from the child node
                    removeEmptyTextNodes(child);
                }
            }
        }
    }

    /**
     * Print the element names and text nodes of an OMElement tree to the console for debugging
     * 
     * @param node The root node of the OMElement tree when initially called, when recursively called it is a child node
     */
    private static void printOMDocument(OMNode node) {
        if (node == null) {
            return;
        }

        if (node instanceof OMText) {
            System.out.println("Text Node: " + ((OMText) node).getText());
            return;
        }

        if (node instanceof OMElement) {
            OMElement element = (OMElement) node;
            System.out.println("Element: " + element.getLocalName());

            // Iterate over the child nodes of the element
            Iterator<OMNode> children = element.getChildren();
            while (children.hasNext()) {
                // Recursively print the element names and text nodes of the child node
                printOMDocument(children.next());
            }
        }
    }
}
