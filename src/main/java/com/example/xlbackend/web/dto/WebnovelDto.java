package com.example.xlbackend.web.dto;

import com.example.xlbackend.domain.entity.Bookmark;
import com.example.xlbackend.domain.entity.Webnovel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class WebnovelDto {
    private Long webnovelId;
    private String title;
    private String thumbnailUrl;
    private String writerName;
    private Short type;
    @Builder
    public WebnovelDto(Webnovel webnovel) {
        this.webnovelId = webnovel.getWebnovelId();
        this.title = webnovel.getTitle();
        this.thumbnailUrl = webnovel.getThumbnailUrl();
        this.writerName = webnovel.getWriter().getWriterName();
        this.type = webnovel.getType();
    }
    @Builder
    public WebnovelDto(Bookmark bookmark) {
        this.webnovelId = bookmark.getWebnovel().getWebnovelId();
        this.title = bookmark.getWebnovel().getTitle();
        this.thumbnailUrl = bookmark.getWebnovel().getThumbnailUrl();
        this.writerName = bookmark.getWebnovel().getWriter().getWriterName();
        this.type = bookmark.getWebnovel().getType();
    }
}
