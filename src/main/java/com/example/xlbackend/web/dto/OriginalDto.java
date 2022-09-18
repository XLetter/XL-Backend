package com.example.xlbackend.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class OriginalDto {
    private Long episodeId;
    private String message;
    private String contents;
    private List<ChoiceDto> choices;
    private List<CommentDto> comments;

}
