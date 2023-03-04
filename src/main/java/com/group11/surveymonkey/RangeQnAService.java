package com.group11.surveymonkey;

import java.util.List;
import java.util.Optional;

public interface RangeQnAService {
    RangeQnA saveRangeQnA(RangeQnA rangeQnA);

    List<RangeQnA> fetchAllRangeQnA();

    Optional<RangeQnA> fetchRangeQnAById(Integer rangeQnAId);

    void addAnswerToRangeQnA(Integer rangeQnAId, RangeAnswer rangeAnswer);
}
