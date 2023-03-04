package com.group11.surveymonkey;

import java.util.List;
import java.util.Optional;

/**
 * This interface is implemented by SurveyServiceImpl,
 * which will expand on the methods under this interface
 * and use it for its own purpose.
 */
public interface SurveyService {
    Survey saveSurvey(Survey survey);
    Optional<Survey> getSurvey(Integer surveyId);
    void addQuestion(Integer questionId, Integer surveyId, Integer questionType);
}
