package com.example.xlbackend.domain.repository;

import com.example.xlbackend.domain.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, String> {
    @Query("select distinct b from Bookmark b join fetch b.webnovel w " +
            "where w.webnovelId = :webnovelId and b.userId = :userId")
    Optional<Bookmark> findBookmarkByWebnovelIdAndUserId(@Param("webnovelId") Long webnovelId, @Param("userId") Long userId);
    List<Bookmark> findAllByUserId(Long userId);
    @Query("select distinct b from Bookmark b join fetch b.webnovel w " +
            "where w.type = :type and b.userId = :userId")
    List<Bookmark> findAllByUserId(@Param("userId") Long userId, @Param("type") Short type);
    @Query("select distinct b from Bookmark b join fetch b.webnovel w " +
            "where w.type = :type and w.genre = :genre and b.userId = :userId")
    List<Bookmark> findAllByUserId(@Param("userId") Long userId, @Param("type") Short type, @Param("genre") String genre);
}
