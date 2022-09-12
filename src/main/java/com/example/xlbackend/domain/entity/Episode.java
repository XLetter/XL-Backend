package com.example.xlbackend.domain.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Getter
@Entity
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long episodeId;

    private Long webnovelId;

    private String episodeTitle;

    private String contents;

    private Timestamp uploadDate;

    private String message;

    private Integer episode;

    private Boolean endingFlag;
}
