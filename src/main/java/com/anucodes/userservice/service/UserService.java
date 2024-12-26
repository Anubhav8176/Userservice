package com.anucodes.userservice.service;


import com.anucodes.userservice.entities.UserInfo;
import com.anucodes.userservice.model.UserInfoDto;
import com.anucodes.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //The function will add/update the user from the data.
    public UserInfoDto createOrUpdate(UserInfoDto userInfoDto){
        UnaryOperator<UserInfo> updatingUser = userInfo ->{
            return userRepository.save(userInfoDto.toUserInfo());
        };

        Supplier<UserInfo> createUser = ()->{
            return userRepository.save(userInfoDto.toUserInfo());
        };

        UserInfo userInfo = userRepository
                .findByUserId(userInfoDto.getUserId())
                .map(updatingUser)
                .orElseGet(createUser);

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


    //The function will get the user from the data.
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
