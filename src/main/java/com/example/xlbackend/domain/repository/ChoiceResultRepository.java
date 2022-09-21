package com.example.xlbackend.domain.repository;

import com.example.xlbackend.domain.entity.ChoiceResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChoiceResultRepository extends JpaRepository<ChoiceResult, String> {
    Optional<ChoiceResult> findByChoiceIdAndOptionIdAndUserId(Long choiceId, Long OptionId, Long UserId);
}
