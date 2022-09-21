package com.example.xlbackend.web;

import com.example.xlbackend.service.ChoiceService;
import com.example.xlbackend.service.EpisodeService;
import com.example.xlbackend.web.dto.ChoiceInputDto;
import com.example.xlbackend.web.dto.OriginalDto;
import com.example.xlbackend.web.dto.SeriesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class EpisodeController {
    private final EpisodeService episodeService;
    private final ChoiceService choiceService;

    @GetMapping("apis/webnovel/series/{webnovelId}/{episodeId}")
    public SeriesDto getSeries(@PathVariable Long webnovelId, @PathVariable Long episodeId) {
        return episodeService.getSeriesEpisode(webnovelId, episodeId);
    }

    @GetMapping("apis/webnovel/original/{webnovelId}/{episodeId}")
    public OriginalDto getOriginals(@PathVariable Long webnovelId, @PathVariable Long episodeId) {
        return episodeService.getOriginalEpisode(webnovelId, episodeId);
    }

    @PostMapping("apis/webnovel/original/{webnovelId}/{episodeId}")
    public ResponseEntity<Object> addBookmark(@PathVariable Long webnovelId, @PathVariable Long episodeId, @RequestBody ChoiceInputDto dto) {
        String status = choiceService.addChoiceResult(dto);
        if (status.equals("success")) {
            return ResponseEntity.ok().body(status);
        } return ResponseEntity.badRequest().body(status);
    }
}
