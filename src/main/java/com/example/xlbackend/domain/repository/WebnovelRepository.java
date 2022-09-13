package com.example.xlbackend.domain.repository;

import com.example.xlbackend.domain.entity.Webnovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WebnovelRepository extends JpaRepository<Webnovel, String> {

    @Query("select w from Webnovel w join fetch w.writer")
    List<Webnovel> findAllWebnovels();
}
