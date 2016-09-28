package com.irobinhood.spring.data.demos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	private static final Logger log= LoggerFactory.getLogger(Application.class);
	
	public static void main(String []args) {
		SpringApplication.run(Application.class);
		
	}
	
	@Bean
	public CommandLineRunner Demo(CustomerRepository customerRepository){
		
		return (args) ->{
			customerRepository.save(new Customer("Amitabh", "Bachchan"));
			customerRepository.save(new Customer("Abhishek", "Bachchan"));
			customerRepository.save(new Customer("Anil", "Kapoor"));
			customerRepository.save(new Customer("Abhay", "Deol"));
			
			log.info("//findall().............");
			log.info("=================================");
			
			for (Customer c : customerRepository.findAll()) {
				log.info(c.toString());
			}
			
			// fetch an individual customer by ID
						Customer customer = customerRepository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
            log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bachchan'):");
			log.info("--------------------------------------------");
			for (Customer result : customerRepository.findByLastName("Bachchan")) {
				log.info(result.toString());
			}
            log.info("");
			
		};
	}
	
}
