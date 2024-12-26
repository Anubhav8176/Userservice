package com.anucodes.userservice.deserializer;

import com.anucodes.userservice.model.UserInfoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class UserInfoDeserializer implements Deserializer<UserInfoDto> {


    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public UserInfoDto deserialize(String s, byte[] bytes) {
        UserInfoDto userInfoDto = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            userInfoDto = objectMapper.readValue(bytes, UserInfoDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfoDto;
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
