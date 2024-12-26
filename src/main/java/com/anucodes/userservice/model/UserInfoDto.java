package com.anucodes.userservice.model;

import com.anucodes.userservice.entities.UserInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoDto {
    private String userId;
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String profilePicture;

    public UserInfo toUserInfo(){
        return UserInfo.builder()
                .userId(userId)
                .username(username)
                .firstName(firstName)
                .lastName(lastName)
                .phoneNumber(phoneNumber)
                .email(email)
                .profilePicture(profilePicture)
                .build();
    }
}
