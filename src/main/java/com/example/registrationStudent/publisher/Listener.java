package com.example.registrationStudent.publisher;

import com.example.registrationStudent.config.StudentCreationProperties;
import com.example.registrationStudent.event.UserCreatedEvent;
import com.example.registrationStudent.event.UserDeletedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
public class Listener {
    private final StudentCreationProperties creationProperties;
    @EventListener()
    public void handleCreateEvent(UserCreatedEvent event){
        if(creationProperties.isEnabled())
            System.out.println("Student created: "+ event.getStudent());
    }
    @EventListener()
    public void handleDeletedEvent(UserDeletedEvent event){
        if(creationProperties.isEnabled())
            System.out.println("Student Deleted: "+event.getId());
    }

}
