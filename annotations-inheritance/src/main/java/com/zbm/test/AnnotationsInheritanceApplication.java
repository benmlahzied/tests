package com.zbm.test;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnnotationsInheritanceApplication {
	
	@Autowired
	private Car car;
	
	@Autowired
	private Vehicle vehicle;
	
	public static void main(String[] args) {
		SpringApplication.run(AnnotationsInheritanceApplication.class, args);
	}
	
	@PostConstruct
	public void init(){
		System.out.println(vehicle);
		System.out.println(car);
	}
}
