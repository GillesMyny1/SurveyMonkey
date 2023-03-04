package com.group11.surveymonkey;

import java.util.List;
import java.util.Optional;

public interface ChoiceQnAService {
    ChoiceQnA saveChoiceQnA(ChoiceQnA choiceQnA);

    List<ChoiceQnA> fetchAllChoiceQnA();

    Optional<ChoiceQnA> fetchChoiceQnAById(Integer choiceQnAId);

    void addAnswerToChoiceQnA(Integer choiceQnAId, ChoiceAnswer choiceAnswer);
}
