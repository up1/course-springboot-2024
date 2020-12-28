package com.workshop.day1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import static java.lang.System.out;

@SpringBootApplication
public class Day1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context
				= SpringApplication.run(Day1Application.class, args);
		String[] beans = context.getBeanDefinitionNames();
		for (String bean : beans) {
			out.println(bean);
		}

		int beanCount = context.getBeanDefinitionCount();
		out.println(beanCount);

		MainComponent main = context.getBean(MainComponent.class);
		main.start();

	}

}
