package com.example.registrationStudent.shelController;

import com.example.registrationStudent.dto.Student;
import com.example.registrationStudent.publisher.Publisher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.UUID;

@ShellComponent
public class StudentShellController  {
    private final Publisher publisher;

    public StudentShellController(Publisher publisher) {
        this.publisher = publisher;
    }

    @ShellMethod(key="add")
    public void addStudent(@ShellOption(value = "f") String firstName, @ShellOption("l") String lastName, @ShellOption(value = "a") int age ){
        String id = UUID.randomUUID().toString();
        Student newStudent = new Student(id,firstName, lastName, age);
        publisher.createStudent("create", newStudent);

    }
    @ShellMethod(key="delete")
    public void deleteStudent(@ShellOption(value = "id") String id ){
        publisher.deleteStudent("delete", id);
    }
    @ShellMethod(key = "clear")
    public void clearStudent(){
        publisher.clearStudents();
    }
    @ShellMethod(key="list")
    public void listOfStudent(){
        publisher.lookThroughStudent();
    }



}
