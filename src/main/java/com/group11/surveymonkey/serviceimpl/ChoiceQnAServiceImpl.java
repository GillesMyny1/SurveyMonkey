package com.group11.surveymonkey.serviceimpl;

import com.group11.surveymonkey.entity.ChoiceAnswer;
import com.group11.surveymonkey.entity.ChoiceQnA;
import com.group11.surveymonkey.repository.ChoiceAnswerRepository;
import com.group11.surveymonkey.repository.ChoiceQnARepository;
import com.group11.surveymonkey.service.ChoiceQnAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChoiceQnAServiceImpl implements ChoiceQnAService {
    @Autowired
    private ChoiceQnARepository choiceQnARepository;

    @Autowired
    private ChoiceAnswerRepository choiceAnswerRepository;

    /*
    Post Operations
     */
    @Override
    public ChoiceQnA saveChoiceQnA(ChoiceQnA choiceQnA) {
        return choiceQnARepository.save(choiceQnA);
    }

    /*
    Get Operations
     */
    @Override
    public List<ChoiceQnA> fetchAllChoiceQnA() {
        return (List<ChoiceQnA>) choiceQnARepository.findAll();
    }

    @Override
    public Optional<ChoiceQnA> fetchChoiceQnAById(Integer choiceQnAId) {
        return choiceQnARepository.findById(choiceQnAId);
    }

    /*
    Put Operations
     */
    @Override
    public void addAnswerToChoiceQnA(Integer choiceQnAId, ChoiceAnswer choiceAnswer) {
        ChoiceQnA choiceQnA = choiceQnARepository.findById(choiceQnAId).get();
        choiceQnA.addChoiceAnswer(choiceAnswer);
        choiceQnARepository.save(choiceQnA);
    }

    /*
    Delete Operations
     */
}
