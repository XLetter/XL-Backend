package com.example.xlbackend.domain.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
public class Webnovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long webnovelId;

    private Long writerId;

    private String title;

    private String thumbnailUrl;

    private String genre;

    private String summary;

    private Short type;

    private Integer count;
}
