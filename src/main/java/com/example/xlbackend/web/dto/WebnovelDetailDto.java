package com.example.xlbackend.web.dto;

import com.example.xlbackend.domain.entity.Webnovel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class WebnovelDetailDto {
    private String summary;
    private String illustrationWrtier;
    private List<EpisodeDto> episodeList;
    @Builder
    public WebnovelDetailDto(Webnovel webnovel, List<EpisodeDto> episodeList) {
        this.summary = webnovel.getSummary();
        this.illustrationWrtier = webnovel.getIllustrationWrtier();
        this.episodeList = episodeList;
    }
}
