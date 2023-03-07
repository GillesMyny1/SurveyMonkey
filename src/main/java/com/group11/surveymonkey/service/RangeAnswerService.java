package com.group11.surveymonkey.service;

import com.group11.surveymonkey.entity.RangeAnswer;

import java.util.List;
import java.util.Optional;

public interface RangeAnswerService {
    RangeAnswer saveRangeAnswer(RangeAnswer rangeAnswer);

    List<RangeAnswer> fetchAllRangeAnswer();

    Optional<RangeAnswer> fetchRangeAnswerById(Integer rangeAnswerId);
}
