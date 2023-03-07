package com.group11.surveymonkey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private TextQnARepository textQnARepository;

    @Autowired
    private RangeQnARepository rangeQnARepository;

    @Autowired
    private ChoiceQnARepository choiceQnARepository;

    /*
    Post Operations
     */
    @Override
    public Survey saveSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    /*
    Get Operations
     */
    @Override
    public List<Survey> fetchAllSurvey() {
        return (List<Survey>) surveyRepository.findAll();
    }

    @Override
    public Optional<Survey> fetchSurveyById(Integer surveyId) {
        return surveyRepository.findById(surveyId);
    }

    /*
    Put Operations
     */
    /*
    @Override
    public void addQuestion(Integer questionId, Integer surveyId, Integer questionType) {
        Survey upSurvey = surveyRepository.findById(surveyId).get();
        if (questionType == 0) {
            TextQnA textQnA = textQnARepository.findById(questionId).get();
            upSurvey.addTextQnA(textQnA);
        }
        else if (questionType == 1) {
            RangeQnA rangeQnA = rangeQnARepository.findById(questionId).get();
            upSurvey.addRangeQnA(rangeQnA);
        }
        else {
            ChoiceQnA choiceQnA = choiceQnARepository.findById(questionId).get();
            upSurvey.addChoiceQnA(choiceQnA);
        }
        surveyRepository.save(upSurvey);
    }
    */

    /*
    Delete Operations
     */
}
