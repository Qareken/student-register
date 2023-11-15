package com.example.registrationStudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class RegistrationStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationStudentApplication.class, args);
	}
	@EventListener(ApplicationStartedEvent.class)
	public void  runApplication(){
		System.out.println("Student Register started with shell command");
	}
}
