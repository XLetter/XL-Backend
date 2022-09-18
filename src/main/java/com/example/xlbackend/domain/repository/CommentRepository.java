package com.example.xlbackend.domain.repository;

import com.example.xlbackend.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, String> {
    List<Comment> findAllByEpisodeId(Long episodeId);
}
