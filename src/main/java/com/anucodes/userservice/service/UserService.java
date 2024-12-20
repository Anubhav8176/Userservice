package com.anucodes.userservice.service;


import com.anucodes.userservice.entities.UserInfo;
import com.anucodes.userservice.model.UserInfoDto;
import com.anucodes.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserInfoDto searchUser(String username) throws Exception{

        Optional<UserInfo> fetchedUserInfo = userRepository.findByUsername(username);
        if(fetchedUserInfo.isEmpty()) throw new Exception("No username found with username!!");
        UserInfo userInfo = fetchedUserInfo.get();

        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getUsername(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePicture()
        );
    }

    public UserInfoDto getUser(UserInfoDto userDto) throws Exception{

        Optional<UserInfo> userInfoDto = userRepository.findByUserId(userDto.getUserId());
        if (userInfoDto.isEmpty()) throw new Exception("User not found!!");
        UserInfo userInfo = userInfoDto.get();

        return new UserInfoDto(
                userInfo.getUserId(),
                userInfo.getUsername(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePicture()
        );

    }
}
