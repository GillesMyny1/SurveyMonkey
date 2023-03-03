package com.group11.surveymonkey;

import java.util.*;

public interface TextAnswerService {
    TextAnswer saveTextAnswer(TextAnswer textAnswer);

    List<TextAnswer> fetchAllTextAnswer();

    Optional<TextAnswer> fetchTextAnswerById(Integer textAnswerId);
}
