package com.example.xlbackend.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class CommentDto {
    private Long commentId;
    private String nickname;
    private String contents;
    private Timestamp time;

    @Builder
    public CommentDto(Long commentId, String nickname, String contents, Timestamp time) {
        this.commentId = commentId;
        this.nickname = nickname;
        this.contents = contents;
        this.time = time;
    }
}
