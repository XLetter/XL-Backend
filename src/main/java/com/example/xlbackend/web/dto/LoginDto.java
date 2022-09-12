package com.example.xlbackend.web.dto;

import com.example.xlbackend.domain.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginDto {
    private Long userId;
    private String nickname;

    @Builder
    public LoginDto(User user) {
        this.userId = user.getUserId();
        this.nickname = user.getNickname();
    }
}
