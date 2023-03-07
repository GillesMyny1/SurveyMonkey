package com.group11.surveymonkey.serviceimpl;

import com.group11.surveymonkey.entity.ChoiceAnswer;
import com.group11.surveymonkey.repository.ChoiceAnswerRepository;
import com.group11.surveymonkey.service.ChoiceAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChoiceAnswerServiceImpl implements ChoiceAnswerService {
    @Autowired
    ChoiceAnswerRepository choiceAnswerRepository;

    /*
    Post Operations
     */
    @Override
    public ChoiceAnswer saveChoiceAnswer(ChoiceAnswer choiceAnswer) {
        return choiceAnswerRepository.save(choiceAnswer);
    }

    /*
    Get Operations
     */
    @Override
    public List<ChoiceAnswer> fetchAllChoiceAnswer() {
        return (List<ChoiceAnswer>) choiceAnswerRepository.findAll();
    }

    @Override
    public Optional<ChoiceAnswer> fetchChoiceAnswerById(Integer choiceAnswerId) {
        return choiceAnswerRepository.findById(choiceAnswerId);
    }

    /*
    Put Operations
     */

    /*
    Delete Operations
     */
}
