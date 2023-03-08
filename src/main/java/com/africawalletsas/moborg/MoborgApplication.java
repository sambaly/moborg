package com.africawalletsas.moborg;

import com.africawalletsas.moborg.domain.HuddleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MoborgApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoborgApplication.class, args);
	}

	@Bean
	public HuddleService createHuddleService() {
		return new HuddleService(null);
	}

}
