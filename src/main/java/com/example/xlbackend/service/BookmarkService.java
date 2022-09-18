package com.example.xlbackend.service;

import com.example.xlbackend.domain.entity.Bookmark;
import com.example.xlbackend.domain.entity.Webnovel;
import com.example.xlbackend.domain.repository.BookmarkRepository;
import com.example.xlbackend.domain.repository.WebnovelRepository;
import com.example.xlbackend.web.dto.WebnovelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
    private final WebnovelRepository webnovelRepository;

    @Transactional(readOnly = true)
    public Bookmark checkExist(Long webnovelId, Long userId) {
        return bookmarkRepository.findBookmarkByWebnovelIdAndUserId(webnovelId, userId).orElse(null);
    }

    @Transactional
    public String updateBookmark(Bookmark bookmark) {
        String status = "delete";
        if (bookmark.getDeleteFlag() == true) {
            bookmark.updateDeleteFlag(false);
            status = "add";
        } else {
            bookmark.updateDeleteFlag(true);
        }
        bookmarkRepository.save(bookmark);
        return status;
    }

    @Transactional
    public String insertBookmark(Long webnovelId, Long userId) {
        Webnovel webnovel = webnovelRepository.findByWebnovelId(webnovelId);
        Bookmark bookmark = Bookmark.builder().webnovel(webnovel).userId(userId).deleteFlag(false).build();
        bookmarkRepository.save(bookmark);
        return "add";
    }

    @Transactional(readOnly = true)
    public List<WebnovelDto> findBookmark(Long userId) {
        return bookmarkRepository.findAllByUserId(userId)
                .stream().map(WebnovelDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<WebnovelDto> findBookmarkByType(Long userId, Short type) {
        return bookmarkRepository.findAllByUserId(userId, type)
                .stream().map(WebnovelDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<WebnovelDto> findBookmarkByTypeAndGenre(Long userId, Short type, String genre) {
        return bookmarkRepository.findAllByUserId(userId, type, genre)
                .stream().map(WebnovelDto::new).collect(Collectors.toList());
    }
}
