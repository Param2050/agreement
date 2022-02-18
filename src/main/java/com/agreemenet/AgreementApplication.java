package com.agreemenet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class AgreementApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(AgreementApplication.class, args);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
