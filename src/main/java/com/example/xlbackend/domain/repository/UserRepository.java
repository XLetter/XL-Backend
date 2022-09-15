package com.example.xlbackend.domain.repository;

import com.example.xlbackend.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByAddress(String address);
    Optional<User> findByUserId(Long userId);
}
