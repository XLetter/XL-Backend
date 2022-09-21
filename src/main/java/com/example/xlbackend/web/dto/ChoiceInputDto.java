package com.example.xlbackend.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ChoiceInputDto {
    private Long userId;
    private Long optionId;
    private Long choiceId;

    @Builder
    public ChoiceInputDto(Long userId, Long optionId, Long choiceId) {
        this.userId = userId;
        this.optionId = optionId;
        this.choiceId = choiceId;
    }
}
