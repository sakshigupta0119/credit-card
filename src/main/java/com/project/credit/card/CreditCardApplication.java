package com.project.credit.card;

import com.project.credit.card.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.logging.Logger;

@SpringBootApplication
@EnableSwagger2
public class CreditCardApplication {
	Logger logger = Logger.getLogger(CreditCardApplication.class.getSimpleName());

	public static void main(String[] args) {
		SpringApplication.run(CreditCardApplication.class, args);


	}
	@Autowired
	private CustomerRepository customerRepository;

	public void init()
	{
		logger.info("Initialized");
	}
}



