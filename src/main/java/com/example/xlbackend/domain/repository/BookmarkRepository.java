package com.example.xlbackend.domain.repository;

import com.example.xlbackend.domain.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, String> {
    Optional<Bookmark> findBookmarkByWebnovelIdAndUserId(Long webnovelId, Long userId);
}
