package com.group11.surveymonkey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class TextAnswerServiceImpl implements TextAnswerService {
    @Autowired TextAnswerRepository textAnswerRepository;

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
