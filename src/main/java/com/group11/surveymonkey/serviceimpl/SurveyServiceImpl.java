package com.group11.surveymonkey.serviceimpl;

import com.group11.surveymonkey.entity.Survey;
import com.group11.surveymonkey.repository.ChoiceQnARepository;
import com.group11.surveymonkey.repository.RangeQnARepository;
import com.group11.surveymonkey.repository.SurveyRepository;
import com.group11.surveymonkey.repository.TextQnARepository;
import com.group11.surveymonkey.service.SurveyService;
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
    Delete Operations
     */
}
