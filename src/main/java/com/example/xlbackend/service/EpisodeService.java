package com.example.xlbackend.service;

import com.example.xlbackend.domain.entity.Choice;
import com.example.xlbackend.domain.entity.Comment;
import com.example.xlbackend.domain.entity.Episode;
import com.example.xlbackend.domain.repository.ChoiceRepository;
import com.example.xlbackend.domain.repository.CommentRepository;
import com.example.xlbackend.domain.repository.EpisodeRepository;
import com.example.xlbackend.web.dto.ChoiceDto;
import com.example.xlbackend.web.dto.CommentDto;
import com.example.xlbackend.web.dto.OriginalDto;
import com.example.xlbackend.web.dto.SeriesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EpisodeService {
    private final EpisodeRepository episodeRepository;
    private final CommentRepository commentRepository;
    private final ChoiceRepository choiceRepository;

    @Transactional(readOnly = true)
    public SeriesDto getSeriesEpisode(Long webnovelId, Long episodeId) {
        Episode episode = episodeRepository.findByWebnovelIdAndEpisodeId(webnovelId, episodeId);
        List<CommentDto> comments = commentRepository.findAllByEpisodeId(episodeId).stream().map(CommentDto::new).collect(Collectors.toList());
        return SeriesDto.builder().episode(episode).comments(comments).build();
    }

    @Transactional(readOnly = true)
    public OriginalDto getOriginalEpisode(Long webnovelId, Long episodeId) {
        Episode episode = episodeRepository.findByWebnovelIdAndEpisodeId(webnovelId, episodeId);
        List<CommentDto> comments = commentRepository.findAllByEpisodeId(episodeId).stream().map(CommentDto::new).collect(Collectors.toList());
        List<ChoiceDto> choices = choiceRepository.findAllByEpisodeId(episodeId).stream().map(ChoiceDto::new).collect(Collectors.toList());
        return OriginalDto.builder().episode(episode).comments(comments).choices(choices).build();
    }
}
