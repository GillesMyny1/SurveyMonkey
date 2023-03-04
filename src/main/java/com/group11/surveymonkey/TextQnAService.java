package com.group11.surveymonkey;

import java.util.*;

public interface TextQnAService {
    TextQnA saveTextQnA(TextQnA textQnA);

    List<TextQnA> fetchAllTextQnA();

    Optional<TextQnA> fetchTextQnAById(Integer textQnAId);

    void addAnswerToTextQnA(Integer textQnAId, TextAnswer textAnswer);
}
