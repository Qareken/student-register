package com.example.registrationStudent.config;

import com.example.registrationStudent.dto.Student;
import com.example.registrationStudent.publisher.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "student-creation")
@Data
@Slf4j
public class StudentCreationProperties {
   private  ApplicationEventPublisher eventPublisher;
    private boolean enabled;
   private final Map<String , Student> studentMap =new HashMap<>();
    private final Logger logger =LoggerFactory.getLogger(StudentCreationProperties.class);
    @Bean
    public Publisher publisher(){
        if(enabled){
            for(int i=0; i<5; i++){
                String id = UUID.randomUUID().toString();
                Student student = new Student();
                student.setId(id);
                student.setFirstName("DefaultName"+i);
                student.setLastName("DefaultLastname"+i);
                student.setAge(20+i);
                studentMap.put(id, student);
            }
            return new Publisher(eventPublisher, studentMap);
        }
       return new Publisher(eventPublisher, studentMap);
    }



}
