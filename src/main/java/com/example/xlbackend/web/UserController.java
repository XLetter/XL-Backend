package com.example.xlbackend.web;

import com.example.xlbackend.domain.entity.User;
import com.example.xlbackend.service.AwsS3Service;
import com.example.xlbackend.service.UserService;
import com.example.xlbackend.web.dto.LoginDto;
import com.example.xlbackend.web.dto.MyPageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    private final AwsS3Service awsS3Service;

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

    @PostMapping("apis/users/{userId}")
    public ResponseEntity<Object> editUserInfo(@PathVariable Long userId, @RequestParam("file") MultipartFile file, @RequestParam("nickname") String nickname) {
        try {
            String profile = awsS3Service.upload(file);
            String status = userService.updateUserInfo(userId, profile, nickname);
            Map<String, String> result = new HashMap<>();
            result.put("nickname", nickname);
            result.put("profile", profile);
            return ResponseEntity.ok().body(result);
        } catch(Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().body("failed");
        }
    }

}
