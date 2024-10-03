package com.pms.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author vinod.nagulkar
 * This is main class
 */
@SpringBootApplication
@ComponentScan("com.pms")
@EntityScan({ "com.pms.model" })
@EnableJpaRepositories(basePackages = "com.pms.dao")
public class PmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmsApplication.class, args);
	}

}
