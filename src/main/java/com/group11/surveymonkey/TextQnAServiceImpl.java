package com.group11.surveymonkey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TextQnAServiceImpl implements TextQnAService {
    @Autowired
    private TextQnARepository textQnARepository;

    @Autowired
    private TextAnswerRepository textAnswerRepository;

    /*
    Post Operations
     */
    @Override
    public TextQnA saveTextQnA(TextQnA textQnA) {
        return textQnARepository.save(textQnA);
    }

    /*
    Get Operations
     */
    @Override
    public List<TextQnA> fetchAllTextQnA() {
        return (List<TextQnA>) textQnARepository.findAll();
    }

    @Override
    public Optional<TextQnA> fetchTextQnAById(Integer textQnAId) {
        return textQnARepository.findById(textQnAId);
    }

    /*
    Put Operations
     */
    public void addAnswerToTextQnA(Integer textQnAId, TextAnswer textAnswer) {
        TextQnA textQnA = textQnARepository.findById(textQnAId).get();
        textQnA.addTextAnswer(textAnswer);
        textQnARepository.save(textQnA);
    }

    /*
    Delete Operations
     */
}
