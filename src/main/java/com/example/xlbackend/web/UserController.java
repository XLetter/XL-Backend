package com.example.xlbackend.web;

import com.example.xlbackend.domain.entity.User;
import com.example.xlbackend.service.UserService;
import com.example.xlbackend.web.dto.LoginDto;
import com.example.xlbackend.web.dto.MyPageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("apis/users/login/{address}")
    public LoginDto login(@PathVariable String address) {
        return userService.findByAddress(address);
    }

    @PostMapping("apis/users/register")
    public LoginDto register(@RequestParam String address, @RequestParam String nickname) {
        LoginDto loginDto = userService.register(address, nickname);
        return loginDto;
    }

    @GetMapping("apis/users/{userId}")
    public MyPageDto mypage(@PathVariable Long userId) {
        return userService.findById(userId);
    }
}
