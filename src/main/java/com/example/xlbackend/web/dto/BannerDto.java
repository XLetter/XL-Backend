package com.example.xlbackend.web.dto;

import com.example.xlbackend.domain.entity.Webnovel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BannerDto {
    private String title;
    private String bannerUrl;
    private String summary;

    @Builder
    public BannerDto(Webnovel webnovel) {
        this.title = webnovel.getTitle();
        this.bannerUrl = webnovel.getBannerUrl();
        this.summary = webnovel.getSummary();
    }
}
