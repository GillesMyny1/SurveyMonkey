package com.group11.surveymonkey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SurveyServiceImpl implements SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;
    private TextQnARepository textQnARepository;
    private RangeQnARepository rangeQnARepository;
    private ChoiceQnARepository choiceQnARepository;
    @Override
    public Survey saveSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public Optional<Survey> getSurvey(Integer surveyId) {
        return surveyRepository.findById(surveyId);
    }

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
}
