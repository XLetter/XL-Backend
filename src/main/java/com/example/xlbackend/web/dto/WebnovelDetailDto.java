package com.example.xlbackend.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class WebnovelDetailDto {
    private String summary;
    private List<EpisodeDto> episodeList;
    @Builder
    public WebnovelDetailDto(String summary, List<EpisodeDto> episodeList) {
        this.summary = summary;
        this.episodeList = episodeList;
    }
}
