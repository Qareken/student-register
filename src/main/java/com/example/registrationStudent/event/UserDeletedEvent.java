package com.example.registrationStudent.event;

import com.example.registrationStudent.config.StudentCreationProperties;
import com.example.registrationStudent.dto.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDeletedEvent {
    private String eventType;
    private String id;

}
