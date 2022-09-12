package com.example.xlbackend.service;

import com.example.xlbackend.domain.entity.User;
import com.example.xlbackend.domain.repository.UserRepository;
import com.example.xlbackend.web.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public LoginDto findByAddress(String address) {
        Optional<User> user = userRepository.findByAddress(address);
        LoginDto loginDto = user.map(LoginDto::new).orElse(null);
        return loginDto;
    }
}
