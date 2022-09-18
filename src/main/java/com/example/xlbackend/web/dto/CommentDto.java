package com.example.xlbackend.web.dto;

import com.example.xlbackend.domain.entity.Comment;
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
    public CommentDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.nickname = comment.getNickname();
        this.contents = comment.getContents();
        this.time = comment.getWriteDate();
    }
}
