// package com.hitachi.domhash.test;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import java.io.IOException;

// import javax.xml.stream.FactoryConfigurationError;
// import javax.xml.stream.XMLStreamException;

// import org.junit.jupiter.api.Test;

// import com.hitachi.domhash.service.DomhashGenerator;

// class DomhashGeneratorTestExample {

//     @Test
//     void testGenerateDomHash() throws IOException, XMLStreamException, FactoryConfigurationError {
//         // Define the expected hash value for the XML document
//         String expectedHash = "a30736c37cc3d23713e8f0e2e43fa3ed0134de43";
        
//         // Define the XML document as a byte array
//         byte[] xml = "<?xml version=\"1.0\"?><root xmlns:ec='http://ecommerce.org/schema'><ec:order><ec:orderHeader><ec:orderNumber>123456</ec:orderNumber><ec:orderDate>2012-01-01</ec:orderDate><ec:orderTotal>100.00</ec:orderTotal></ec:orderHeader><ec:orderItems><ec:orderItem><ec:productID>123</ec:productID><ec:productName>Widget</ec:productName><ec:quantity>1</ec:quantity><ec:price>100.00</ec:price></ec:orderItem></ec:orderItems></ec:order></root>".getBytes();
        
//         // Calculate the actual hash value using the DomhashGenerator class
//         String actualHash = DomhashGenerator.generateDomHash(xml);
        
//         // Compare the actual and expected hash values
//         assertEquals(expectedHash, actualHash);
//     }

// }
