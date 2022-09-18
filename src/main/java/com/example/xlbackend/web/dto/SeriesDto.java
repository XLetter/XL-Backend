package com.example.xlbackend.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class SeriesDto {
    private Long episodeId;
    private String message;
    private String contents;
    private List<CommentDto> comments;

    @Builder
    public SeriesDto(Long episodeId, String message, String contents, List<CommentDto> comments) {
        this.episodeId = episodeId;
        this.message = message;
        this.contents = contents;
        this.comments = comments;
    }
}
