package com.group11.surveymonkey;

import java.util.List;
import java.util.Optional;

public interface ChoiceAnswerService {
    ChoiceAnswer saveChoiceAnswer(ChoiceAnswer choiceAnswer);

    List<ChoiceAnswer> fetchAllChoiceAnswer();

    Optional<ChoiceAnswer> fetchChoiceAnswerById(Integer choiceAnswerId);
}
