package com.example.xlbackend.web.dto;

import com.example.xlbackend.domain.entity.Episode;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class EpisodeDto {
    private Long episodeId;
    private String episodeTitle;
    private Timestamp uploadDate;

    @Builder
    public EpisodeDto(Episode episode) {
        this.episodeId = episode.getEpisodeId();
        this.episodeTitle = episode.getEpisodeTitle();
        this.uploadDate = episode.getUploadDate();
    }
}
