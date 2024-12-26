package com.anucodes.userservice.entities;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userId;
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String profilePicture;
}
