package com.group11.surveymonkey.service;

import com.group11.surveymonkey.entity.Survey;

import java.util.*;

public interface SurveyService {
    Survey saveSurvey(Survey survey);

    List<Survey> fetchAllSurvey();

    Optional<Survey> fetchSurveyById(Integer surveyId);

    /*
    void addQuestion(Integer questionId, Integer surveyId, Integer questionType);
     */
}
