package com.skilldistillery.PGA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.skilldistillery.PGA")
public class PgamvcBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PgamvcBootApplication.class, args);
	}

}
