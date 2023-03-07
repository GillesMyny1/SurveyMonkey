package com.group11.surveymonkey.service;

import com.group11.surveymonkey.entity.TextAnswer;
import com.group11.surveymonkey.entity.TextQnA;

import java.util.*;

public interface TextQnAService {
    TextQnA saveTextQnA(TextQnA textQnA);

    List<TextQnA> fetchAllTextQnA();

    Optional<TextQnA> fetchTextQnAById(Integer textQnAId);

    void addAnswerToTextQnA(Integer textQnAId, TextAnswer textAnswer);
}
