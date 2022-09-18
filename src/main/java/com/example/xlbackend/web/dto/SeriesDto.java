package com.example.xlbackend.web.dto;

import com.example.xlbackend.domain.entity.Episode;
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
    public SeriesDto(Episode episode, List<CommentDto> comments) {
        this.episodeId = episode.getEpisodeId();
        this.message = episode.getMessage();
        this.contents = episode.getContents();
        this.comments = comments;
    }
}
