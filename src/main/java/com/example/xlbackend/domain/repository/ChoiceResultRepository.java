package com.example.xlbackend.domain.repository;

import com.example.xlbackend.domain.entity.ChoiceResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ChoiceResultRepository extends JpaRepository<ChoiceResult, String> {
    @Query("select distinct r from ChoiceResult r left join fetch r.choice c " +
            "where c.choiceId = :choiceId and r.optionId = :optionId and r.userId = :userId")
    Optional<ChoiceResult> findByChoiceIdAndOptionIdAndUserId(@Param("choiceId") Long choiceId, @Param("optionId") Long OptionId, @Param("userId") Long UserId);
}
