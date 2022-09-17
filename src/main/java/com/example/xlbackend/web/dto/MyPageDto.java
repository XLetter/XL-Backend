package com.example.xlbackend.web.dto;

import com.example.xlbackend.domain.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MyPageDto {
    private String nickname;
    private String address;
    private String profile;

    @Builder
    public MyPageDto (User user) {
        this.nickname = user.getNickname();
        this.address = user.getAddress();
        this.profile = user.getProfile();
    }
}
