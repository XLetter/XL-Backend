package com.example.xlbackend.web.dto;

import com.example.xlbackend.domain.entity.Choice;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ChoiceDto {
    private Long choiceId;
    private String question;
    private List<ChoiceOptionDto> choiceOptions;

    @Builder
    public ChoiceDto(Choice choice) {
        this.choiceId = choice.getChoiceId();
        this.question = choice.getQuestion();
        this.choiceOptions = choice.getOptions().stream().map(ChoiceOptionDto::new).collect(Collectors.toList());
    }
}
