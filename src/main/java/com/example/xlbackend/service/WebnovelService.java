package com.example.xlbackend.service;

import com.example.xlbackend.domain.entity.Episode;
import com.example.xlbackend.domain.entity.Webnovel;
import com.example.xlbackend.domain.repository.EpisodeRepository;
import com.example.xlbackend.domain.repository.WebnovelRepository;
import com.example.xlbackend.web.dto.EpisodeDto;
import com.example.xlbackend.web.dto.WebnovelDetailDto;
import com.example.xlbackend.web.dto.WebnovelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WebnovelService {
    private final WebnovelRepository webnovelRepository;
    private final EpisodeRepository episodeRepository;

    @Transactional(readOnly = true)
    public List<WebnovelDto> getWebnovelList() {
        return webnovelRepository.findAllWebnovels()
                .stream().map(WebnovelDto::new).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<WebnovelDto> getWebnovelListByType(Short type) {
        return webnovelRepository.findAllWebnovelsByType(type)
                .stream().map(WebnovelDto::new).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<WebnovelDto> getWebnovelListByTypeAndGenre(Short type, String genre) {
        return webnovelRepository.findAllWebnovelsByTypeAndGenre(type, genre)
                .stream().map(WebnovelDto::new).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public WebnovelDetailDto getWebnovelDetails(Long webnovelId) {
        String summary = webnovelRepository.findByWebnovelId(webnovelId).getSummary();
        List<EpisodeDto> episodes = episodeRepository.findAllByWebnovelId(webnovelId).stream()
                .map(EpisodeDto::new).collect(Collectors.toList());
        return WebnovelDetailDto.builder().summary(summary).episodeList(episodes).build();
    }
    @Transactional
    public String incrementCount(Long webnovelId) {
        Webnovel webnovel = webnovelRepository.findByWebnovelId(webnovelId);
        webnovel.incrementCount();
        webnovelRepository.save(webnovel);
        return "success";
    }
    @Transactional
    public String decrementCount(Long webnovelId) {
        Webnovel webnovel = webnovelRepository.findByWebnovelId(webnovelId);
        webnovel.decrementCount();
        webnovelRepository.save(webnovel);
        return "success";
    }

}
