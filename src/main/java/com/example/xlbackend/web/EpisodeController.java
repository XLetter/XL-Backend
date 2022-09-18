package com.example.xlbackend.web;

import com.example.xlbackend.service.EpisodeService;
import com.example.xlbackend.web.dto.SeriesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EpisodeController {
    private final EpisodeService episodeService;

    @GetMapping("apis/webnovel/series/{webnovelId}/{episodeId}")
    public SeriesDto getSeries(@PathVariable Long webnovelId, @PathVariable Long episodeId) {
        return episodeService.getSeriesEpisode(webnovelId, episodeId);
    }
}
