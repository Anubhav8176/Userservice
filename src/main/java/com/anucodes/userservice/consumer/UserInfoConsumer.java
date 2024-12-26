package com.anucodes.userservice.consumer;

import com.anucodes.userservice.model.UserInfoDto;
import com.anucodes.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoConsumer {

    @Autowired
    private UserService userService;

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(UserInfoDto eventData){
        try {
            userService.createOrUpdate(eventData);
            System.out.println("This is the event data from the kafka: "+eventData);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
