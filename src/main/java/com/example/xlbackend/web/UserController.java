package com.example.xlbackend.web;

import com.example.xlbackend.service.UserService;
import com.example.xlbackend.web.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("api/users/login/{address}")
    public LoginDto login(@PathVariable String address) {
        return userService.findByAddress(address);
    }
}
