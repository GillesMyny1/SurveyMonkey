package com.group11.surveymonkey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RangeQnAServiceImpl implements RangeQnAService{
    @Autowired
    private RangeQnARepository rangeQnARepository;

    @Autowired
    private RangeAnswerRepository rangeAnswerRepository;

    /*
    Post Operations
     */
    @Override
    public RangeQnA saveRangeQnA(RangeQnA rangeQnA) {
        return rangeQnARepository.save(rangeQnA);
    }

    /*
    Get Operations
     */
    @Override
    public List<RangeQnA> fetchAllRangeQnA() {
        return (List<RangeQnA>) rangeQnARepository.findAll();
    }

    @Override
    public Optional<RangeQnA> fetchRangeQnAById(Integer rangeQnAId) {
        return rangeQnARepository.findById(rangeQnAId);
    }

    /*
    Put Operations
     */
    @Override
    public void addAnswerToRangeQnA(Integer rangeQnAId, RangeAnswer rangeAnswer) {
        RangeQnA rangeQnA = rangeQnARepository.findById(rangeQnAId).get();
        rangeQnA.addRangeAnswer(rangeAnswer);
        rangeQnARepository.save(rangeQnA);
    }

    /*
    Delete Operations
     */
}
