package com.example.xlbackend.domain.repository;

import com.example.xlbackend.domain.entity.Webnovel;
import com.example.xlbackend.service.WebnovelService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface WebnovelRepository extends JpaRepository<Webnovel, String> {

    @Query("select distinct w from Webnovel w join fetch w.writer")
    List<Webnovel> findAllWebnovels();

    @Query("select distinct w from Webnovel w join fetch w.writer where w.type = :type")
    List<Webnovel> findAllWebnovelsByType(@Param("type") Short type);

    @Query("select distinct w from Webnovel w join fetch w.writer where w.type = :type and w.genre = :genre")
    List<Webnovel> findAllWebnovelsByTypeAndGenre(@Param("type") Short type, @Param("genre") String genre);

    Webnovel findByWebnovelId(Long webnovelId);

    List<Webnovel> findByTitleContaining(String keyword);
}
