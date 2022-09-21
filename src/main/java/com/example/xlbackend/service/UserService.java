package com.example.xlbackend.service;

import com.example.xlbackend.domain.entity.User;
import com.example.xlbackend.domain.repository.UserRepository;
import com.example.xlbackend.web.dto.LoginDto;
import com.example.xlbackend.web.dto.MyPageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    @Transactional(readOnly = true)
    public LoginDto findByAddress(String address) {
        Optional<User> user = userRepository.findByAddress(address);
        LoginDto loginDto = user.map(LoginDto::new).orElse(null);
        return loginDto;
    }

    @Transactional(readOnly = true)
    public MyPageDto findById(Long userId) {
        Optional<User> user = userRepository.findByUserId(userId);
        MyPageDto myPageDto = user.map(MyPageDto::new).orElse(null);
        return myPageDto;
    }

    @Transactional
    public LoginDto register(String address, String nickname) {
        User user = User.builder()
                .address(address)
                .nickname(nickname)
                .writerFlag(false).build();
        LoginDto loginDto = LoginDto.builder().user(userRepository.save(user)).build();
        return loginDto;
    }

    @Transactional
    public String updateUserInfo(Long userId, String profile, String nickname) throws Exception {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new Exception());
        user.updateUserInfo(nickname, profile);
        userRepository.save(user);
        return "success";
    }
}
