package com.example.xlbackend.web.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ChoiceDto {
    private Long choiceId;
    private String question;
    private List<ChoiceOptionDto> choiceOptions;
}
