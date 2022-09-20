package com.example.xlbackend.domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.util.Collections.emptySet;

@Getter
@Entity
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "choice_id")
    private Long choiceId;
    private Long episodeId;
    private String question;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "choice_id")
    private Set<ChoiceOption> options = emptySet();
}
