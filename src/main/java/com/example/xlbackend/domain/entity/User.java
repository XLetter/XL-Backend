package com.example.xlbackend.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String address;
    private String nickname;
    private Boolean writerFlag;
    private String profile;

    @Builder
    public User(String address, String nickname, Boolean writerFlag) {
        this.address = address;
        this.nickname = nickname;
        this.writerFlag = writerFlag;
    }

    public void updateUserInfo(String nickname, String profile) {
        this.nickname = nickname;
        this.profile = profile;
    }
}
