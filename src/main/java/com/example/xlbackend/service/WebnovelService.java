package com.example.xlbackend.service;

import com.example.xlbackend.domain.entity.Episode;
import com.example.xlbackend.domain.repository.EpisodeRepository;
import com.example.xlbackend.domain.repository.WebnovelRepository;
import com.example.xlbackend.web.dto.EpisodeDto;
import com.example.xlbackend.web.dto.WebnovelDetailDto;
import com.example.xlbackend.web.dto.WebnovelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WebnovelService {
    private final WebnovelRepository webnovelRepository;
    private final EpisodeRepository episodeRepository;

    public List<WebnovelDto> getWebnovelList() {
        return webnovelRepository.findAllWebnovels()
                .stream().map(WebnovelDto::new).collect(Collectors.toList());
    }

    public List<WebnovelDto> getWebnovelListByType(Short type) {
        return webnovelRepository.findAllWebnovelsByType(type)
                .stream().map(WebnovelDto::new).collect(Collectors.toList());
    }

    public List<WebnovelDto> getWebnovelListByTypeAndGenre(Short type, String genre) {
        return webnovelRepository.findAllWebnovelsByTypeAndGenre(type, genre)
                .stream().map(WebnovelDto::new).collect(Collectors.toList());
    }

    public WebnovelDetailDto getWebnovelDetails(Long webnovelId) {
        String summary = webnovelRepository.findByWebnovelId(webnovelId).getSummary();
        List<EpisodeDto> episodes = episodeRepository.findAllByWebnovelId(webnovelId).stream()
                .map(EpisodeDto::new).collect(Collectors.toList());
        return WebnovelDetailDto.builder().summary(summary).episodeList(episodes).build();
    }

}
