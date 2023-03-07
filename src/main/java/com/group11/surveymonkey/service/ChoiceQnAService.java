package com.group11.surveymonkey.service;

import com.group11.surveymonkey.entity.ChoiceAnswer;
import com.group11.surveymonkey.entity.ChoiceQnA;

import java.util.List;
import java.util.Optional;

public interface ChoiceQnAService {
    ChoiceQnA saveChoiceQnA(ChoiceQnA choiceQnA);

    List<ChoiceQnA> fetchAllChoiceQnA();

    Optional<ChoiceQnA> fetchChoiceQnAById(Integer choiceQnAId);

    void addAnswerToChoiceQnA(Integer choiceQnAId, ChoiceAnswer choiceAnswer);
}
