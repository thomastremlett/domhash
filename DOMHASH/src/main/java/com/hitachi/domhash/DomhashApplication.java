// This is the package name that contains the DomhashApplication class
package com.hitachi.domhash;

// Import the required classes from the Spring Boot framework
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// The @SpringBootApplication annotation is a convenience annotation that combines 
// @Configuration, @EnableAutoConfiguration, and @ComponentScan annotations. It tells 
// Spring Boot that this class is the entry point for the application.
@SpringBootApplication
public class DomhashApplication {

	// The main method is the entry point for the application. It calls the static run 
	// method of the SpringApplication class to start the Spring Boot application.
	public static void main(String[] args) {
		SpringApplication.run(DomhashApplication.class, args);
	}

}