package com.example.xlbackend.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class ChoiceResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;
    private Long choiceId;
    private Long userId;
    private Long optionId;

    @Builder
    public ChoiceResult(Long choiceId, Long userId, Long optionId) {
        this.choiceId = choiceId;
        this.userId = userId;
        this.optionId = optionId;
    }
}
