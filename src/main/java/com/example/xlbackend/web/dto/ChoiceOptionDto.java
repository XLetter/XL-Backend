package com.example.xlbackend.web.dto;

import com.example.xlbackend.domain.entity.ChoiceOption;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ChoiceOptionDto {
    private Long optionId;
    private String value;

    @Builder
    public ChoiceOptionDto(ChoiceOption choiceOption) {
        this.optionId = choiceOption.getOptionId();
        this.value = choiceOption.getKey();
    }
}
