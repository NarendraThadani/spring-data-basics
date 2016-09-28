package com.irobinhood.spring.cellphonearena.data;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
public class Application {

	private static final Logger log= LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
	
	@Bean
	public CommandLineRunner Demo(PhoneRepository repo){
		
		return args -> {
			
			repo.save(new Phone("Nexus4"));
			repo.save(new Phone("Nexus5"));
			repo.save(new Phone("MotoX"));
			repo.save(new Phone("iPhone7"));
			
			log.info("");
			log.info("------------------------------------------------");
			log.info("-----------Fetching using findAll --------------");
			log.info("------------------------------------------------");
			
			for (Phone p : repo.findAll()) {				
				log.info(p.toString());
			}
			
			log.info("");
			log.info("------------------------------------------------");
			log.info("-----------Fetching using findby ID ------------");
			
			
			Phone p = repo.findOne(1L);
			
			log.info(p.toString());
			log.info("------------------------------------------------");
			log.info("");
			
			
			log.info("");
			log.info("------------------------------------------------");
			log.info("-----------Fetching using findByName -----------");
			
			
			List<Phone> result = repo.findByName("Nexus4");
			
			for (Phone p1 : result) {				
				log.info(p1.toString());
			}
			log.info("------------------------------------------------");
			log.info("");
			
		};
	}

}
