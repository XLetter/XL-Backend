package com.example.xlbackend.domain.repository;

import com.example.xlbackend.domain.entity.Choice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChoiceRepository extends JpaRepository<Choice, String> {
    @Query("select distinct c from Choice c left join fetch c.options " +
            "where c.episodeId = :episodeId")
    List<Choice> findAllByEpisodeId(@Param("episodeId") Long episodeId);
}
