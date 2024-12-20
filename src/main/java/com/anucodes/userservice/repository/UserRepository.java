package com.anucodes.userservice.repository;

import com.anucodes.userservice.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserInfo, String> {

    Optional<UserInfo> findByUserId(String userId);

    Optional<UserInfo> findByUsername(String username);
}
