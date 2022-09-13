package com.example.xlbackend.web;

import com.example.xlbackend.service.WebnovelService;
import com.example.xlbackend.web.dto.WebnovelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class WebnovelController {
    private final WebnovelService webnovelService;

    @GetMapping("apis/webnovel")
    public List<WebnovelDto> getWebnovelList() {
        return webnovelService.getWebnovelList();
    }

}
