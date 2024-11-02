package com.hooniegit.FunctionalJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Functional.Basic;

@SpringBootApplication
public class FunctionalJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionalJavaApplication.class, args);
		
		workspace();
	}
	
	private static void workspace() {
		Basic.basic();
	}

}
