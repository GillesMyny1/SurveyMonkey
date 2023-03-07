package com.group11.surveymonkey.service;

import com.group11.surveymonkey.entity.ChoiceAnswer;

import java.util.List;
import java.util.Optional;

public interface ChoiceAnswerService {
    ChoiceAnswer saveChoiceAnswer(ChoiceAnswer choiceAnswer);

    List<ChoiceAnswer> fetchAllChoiceAnswer();

    Optional<ChoiceAnswer> fetchChoiceAnswerById(Integer choiceAnswerId);
}
