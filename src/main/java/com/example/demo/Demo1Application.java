package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.repository.ProductRepo;

@SpringBootApplication
//@EnableMongoRepositories(basePackageClasses = CustomerRepository.class)
@EnableJpaRepositories

public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}
