package com.example.xlbackend.domain.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class ChoiceOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long optionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "choice_id")
    private Choice choice;

    private String key;

    private Long endingId;

    private Integer weight;
}
