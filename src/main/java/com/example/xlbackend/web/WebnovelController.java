package com.example.xlbackend.web;

import com.example.xlbackend.domain.entity.Webnovel;
import com.example.xlbackend.domain.repository.WebnovelRepository;
import com.example.xlbackend.service.WebnovelService;
import com.example.xlbackend.web.dto.WebnovelDetailDto;
import com.example.xlbackend.web.dto.WebnovelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class WebnovelController {
    private final WebnovelService webnovelService;
    private final WebnovelRepository repository;

    @GetMapping("apis/webnovel")
    public List<WebnovelDto> getWebnovelList(@RequestParam(required = false) Short type, @RequestParam(required = false) String genre) {
        if (type == null) {
            return webnovelService.getWebnovelList();
        } else if (genre == null) {
            return webnovelService.getWebnovelListByType(type);
        }
        return webnovelService.getWebnovelListByTypeAndGenre(type, genre);

    }

    @GetMapping("apis/webnovel/{webnovel_id}")
    public WebnovelDetailDto getWebnovelDetails(@PathVariable Long webnovel_id) {
        return webnovelService.getWebnovelDetails(webnovel_id);
    }

}
