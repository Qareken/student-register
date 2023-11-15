package com.example.registrationStudent.publisher;

import com.example.registrationStudent.dto.Student;
import com.example.registrationStudent.event.UserCreatedEvent;
import com.example.registrationStudent.event.UserDeletedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Data
@AllArgsConstructor

public class Publisher {
    private final ApplicationEventPublisher publisher;
    private  final Map<String, Student> studentMap;
    private final Logger logger = LoggerFactory.getLogger(Publisher.class);
    public void createStudent(String type, Student student){
        studentMap.put(student.getId(), student);
        publisher.publishEvent(new UserCreatedEvent(type, student));
    }
    public void deleteStudent(String type, String id){
        studentMap.remove(id);
        publisher.publishEvent(new UserDeletedEvent(type,  id));
    }

    public void clearStudents() {
        logger.info("clearStudents in publisher called....");
        synchronized (studentMap){
            try {
                studentMap.clear();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        logger.info("after clear student map size "+ studentMap.size());

    }
    public void lookThroughStudent(){
        logger.info("lookThrough studentMap size "+studentMap.size());
        if(!studentMap.isEmpty())
            studentMap.values().forEach(System.out::println);
    }
}
