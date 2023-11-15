package com.example.registrationStudent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private int age;
}
