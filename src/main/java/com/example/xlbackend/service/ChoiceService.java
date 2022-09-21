package com.example.xlbackend.service;

import com.example.xlbackend.domain.entity.ChoiceResult;
import com.example.xlbackend.domain.repository.ChoiceResultRepository;
import com.example.xlbackend.web.dto.ChoiceInputDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ChoiceService {
    private final ChoiceResultRepository choiceResultRepository;

    @Transactional(readOnly = true)
    public boolean checkDuplicate(ChoiceInputDto dto) {
        ChoiceResult result = choiceResultRepository.findByChoiceIdAndOptionIdAndUserId(dto.getChoiceId(), dto.getOptionId(), dto.getUserId()).orElse(null);
        if (result == null) {
            return false;
        } return true;
    }

    @Transactional
    public String addChoiceResult(ChoiceInputDto dto) {
        if (!checkDuplicate(dto)) {
            ChoiceResult result = ChoiceResult.builder().choiceId(dto.getChoiceId()).userId(dto.getUserId()).optionId(dto.getOptionId()).build();
            choiceResultRepository.save(result);
            return "success";
        }
        return "fail";
    }
}
