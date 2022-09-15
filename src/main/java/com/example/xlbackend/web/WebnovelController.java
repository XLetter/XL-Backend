package com.example.xlbackend.web;

import com.example.xlbackend.domain.entity.Bookmark;
import com.example.xlbackend.service.BookmarkService;
import com.example.xlbackend.service.WebnovelService;
import com.example.xlbackend.web.dto.BookmarkDto;
import com.example.xlbackend.web.dto.WebnovelDetailDto;
import com.example.xlbackend.web.dto.WebnovelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class WebnovelController {
    private final WebnovelService webnovelService;
    private final BookmarkService bookmarkService;

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

    @PostMapping("apis/webnovel/bookmark")
    public ResponseEntity<Object> addBookmark(@RequestBody BookmarkDto request) {
        String status = "";
        Bookmark bookmark = bookmarkService.checkExist(request.getWebnovelId(), request.getUserId());
        if (bookmark == null) {
            status = bookmarkService.insertBookmark(request.getWebnovelId(), request.getUserId());
            webnovelService.incrementCount(request.getWebnovelId());
        } else {
            status = bookmarkService.updateBookmark(bookmark);
        }
        return ResponseEntity.ok().body(status);
    }

}
