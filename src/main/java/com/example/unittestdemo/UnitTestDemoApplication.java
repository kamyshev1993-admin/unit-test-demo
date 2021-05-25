package com.example.unittestdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class UnitTestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestDemoApplication.class, args);
	}
}
