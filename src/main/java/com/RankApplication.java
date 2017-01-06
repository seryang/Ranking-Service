package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RankApplication {
	public static void main(String[] args) {
		SpringApplication.run(RankApplication.class, args);
		System.out.println("server on");
	}
}
