package com.example.xlbackend.service;

import com.example.xlbackend.domain.entity.Bookmark;
import com.example.xlbackend.domain.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;

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
        Bookmark bookmark = Bookmark.builder().webnovelId(webnovelId).userId(userId).deleteFlag(false).build();
        bookmarkRepository.save(bookmark);
        return "add";
    }
}
