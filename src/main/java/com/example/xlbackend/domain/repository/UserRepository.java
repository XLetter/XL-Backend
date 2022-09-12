package com.example.xlbackend.domain.repository;

import com.example.xlbackend.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
