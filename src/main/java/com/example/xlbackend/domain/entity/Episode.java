package com.example.xlbackend.domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Entity
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long episodeId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "webnovel_id")
    private Webnovel webnovel;
//    private Long webnovelId;
    private String episodeTitle;
    private String contents;
    private Timestamp uploadDate;
    private String message;
    private Integer episode;
    private Boolean endingFlag;
}
