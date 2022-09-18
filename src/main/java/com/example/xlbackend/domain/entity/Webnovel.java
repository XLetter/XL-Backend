package com.example.xlbackend.domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Webnovel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long webnovelId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private Writer writer;

    private String title;
    private String thumbnailUrl;
    private String genre;
    private String summary;
    private Short type;
    private Integer count;
    @Column(name = "illustration_writer")
    private String illustrationWrtier;

    public void incrementCount() {
        this.count += 1;
    }
    public void decrementCount() {
        this.count -= 1;
    }
}
