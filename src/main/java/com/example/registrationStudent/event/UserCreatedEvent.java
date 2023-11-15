package com.example.registrationStudent.event;

import com.example.registrationStudent.dto.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCreatedEvent {
    private String eventType;
    private Student student;
}
