package com.example.xlbackend.domain.repository;

import com.example.xlbackend.domain.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, String> {
//    @Query("select e from Episode e join fetch e.webnovel w where w = :webnovelId")
//    List<Episode> findAllEpisodes(@Param("webnovelId") Long webnovelId);
    List<Episode> findAllByWebnovelId(Long id);
    Episode findByWebnovelIdAndEpisodeId(Long webnovelId, Long episodeId);
}
