package com.group11.surveymonkey.service;

import com.group11.surveymonkey.entity.TextAnswer;

import java.util.*;

public interface TextAnswerService {
    TextAnswer saveTextAnswer(TextAnswer textAnswer);

    List<TextAnswer> fetchAllTextAnswer();

    Optional<TextAnswer> fetchTextAnswerById(Integer textAnswerId);
}
