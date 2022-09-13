package com.example.xlbackend.service;

import com.example.xlbackend.domain.repository.WebnovelRepository;
import com.example.xlbackend.web.dto.WebnovelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WebnovelService {
    private final WebnovelRepository webnovelRepository;

    public List<WebnovelDto> getWebnovelList() {
        return webnovelRepository.findAllWebnovels()
                .stream().map(WebnovelDto::new).collect(Collectors.toList());
    }
}
