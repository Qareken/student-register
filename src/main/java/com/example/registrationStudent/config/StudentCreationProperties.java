package com.example.registrationStudent.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "student-creation")
@Data
public class StudentCreationProperties {
    private boolean enabled;
}
