package com.group11.surveymonkey.serviceimpl;

import com.group11.surveymonkey.entity.TextAnswer;
import com.group11.surveymonkey.repository.SurveyRepository;
import com.group11.surveymonkey.repository.TextAnswerRepository;
import com.group11.surveymonkey.service.TextAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class TextAnswerServiceImpl implements TextAnswerService {
    @Autowired
    private TextAnswerRepository textAnswerRepository;
    @Autowired
    private SurveyRepository surveyRepository;

    /*
    Post Operations
     */
    @Override
    public TextAnswer saveTextAnswer(TextAnswer textAnswer) {
        return textAnswerRepository.save(textAnswer);
    }

    /*
    Get Operations
     */
    @Override
    public List<TextAnswer> fetchAllTextAnswer() {
        return (List<TextAnswer>) textAnswerRepository.findAll();
    }

    @Override
    public Optional<TextAnswer> fetchTextAnswerById(Integer textAnswerId) {
        return textAnswerRepository.findById(textAnswerId);
    }

    /*
    Put Operations
     */

    /*
    Delete Operations
     */
}
