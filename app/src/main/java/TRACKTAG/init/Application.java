// Declare the package for the Application class
package TRACKTAG.init;

// Import the required Spring Boot classes
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Declare the Application class as a Spring Boot application
@SpringBootApplication
public class Application {

    // Define the main method of the Application class
    public static void main(String[] args) {
        // Call the static run() method of SpringApplication to initialize the SpringBoot application
        // and start the application with the given arguments.
        // The first argument to the run() method is the main application class, and the second argument is the command-line arguments.
        SpringApplication.run(Application.class, args);
    }

}
