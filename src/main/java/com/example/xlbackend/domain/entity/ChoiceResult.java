package com.example.xlbackend.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class ChoiceResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "choice_id")
    private Choice choice;
//    @Column(name = "choice_id")
//    private Long choiceId;
    private Long userId;
    private Long optionId;

    @Builder
    public ChoiceResult(Choice choice, Long userId, Long optionId) {
        this.choice = choice;
        this.userId = userId;
        this.optionId = optionId;
    }
}
