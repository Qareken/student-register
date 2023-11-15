package com.example.registrationStudent.shelController;

import com.example.registrationStudent.dto.Student;
import com.example.registrationStudent.publisher.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.UUID;

@ShellComponent
@Slf4j
public class StudentShellController {
    private final Publisher publisher;
    private final Logger logger = LoggerFactory.getLogger(StudentShellController.class);

    public StudentShellController(Publisher publisher) {
        this.publisher = publisher;
    }

    @ShellMethod(key = "add")
    public void addStudent(@ShellOption(value = "f") String firstName, @ShellOption("l") String lastName, @ShellOption(value = "a") int age) {
        String id = UUID.randomUUID().toString();
        Student newStudent = new Student(id, firstName, lastName, age);
        publisher.createStudent("create", newStudent);

    }

    @ShellMethod(key = "delete")
    public void deleteStudent(@ShellOption(value = "id") String id) {
        publisher.deleteStudent("delete", id);
    }

    @ShellMethod(key = "clearAll")
    public void clearStudent() {
        logger.info("clear method called");
        publisher.clearStudents();
    }

    @ShellMethod(key = "list")
    public void listOfStudent() {
        publisher.lookThroughStudent();
    }

}
