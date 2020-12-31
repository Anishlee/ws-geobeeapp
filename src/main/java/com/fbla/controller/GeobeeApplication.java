package com.fbla.controller;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GeobeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeobeeApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");
			
			GeoBeeController geoBeeController= new GeoBeeController();
			geoBeeController.getCapitalQuestions(10);
			geoBeeController.getFlagsQuestions(10);
			geoBeeController.getNicknamesQuestions(10);
			geoBeeController.getMiscQuestions(10);
			geoBeeController.getQuestionsByState(10);
			geoBeeController.getRandomFactOfTheDay();

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}
