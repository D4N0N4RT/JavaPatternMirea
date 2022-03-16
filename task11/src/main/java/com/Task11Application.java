package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Task11Application {

	public static void main(String[] args) {
		SpringApplication.run(Task11Application.class, args);
		System.out.println("Hello Spring Boot");
	}

	@SuppressWarnings("unused")
	@Component
	@Endpoint(id = "check")
	public static class Check{
		private String d = "a";

		@ReadOperation
		public String get(){
			return d;
		}

		@WriteOperation
		public void write(String x){
			d = x;
		}
	}
}
