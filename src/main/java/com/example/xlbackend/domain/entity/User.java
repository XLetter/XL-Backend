package com.example.xlbackend.domain.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String address;

    private String nickname;

    private Boolean writerFlag;

    private String profile;
}
