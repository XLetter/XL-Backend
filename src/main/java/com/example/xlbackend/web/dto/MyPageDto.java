package com.example.xlbackend.web.dto;

import com.example.xlbackend.domain.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MyPageDto {
    private String nickname;
    private String address;

    @Builder
    public MyPageDto (User user) {
        this.nickname = user.getNickname();
        this.address = user.getAddress();
    }
}
