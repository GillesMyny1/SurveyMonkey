package com.group11.surveymonkey.serviceimpl;

import com.group11.surveymonkey.entity.RangeAnswer;
import com.group11.surveymonkey.repository.RangeAnswerRepository;
import com.group11.surveymonkey.service.RangeAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RangeAnswerServiceImpl implements RangeAnswerService {
    @Autowired
    RangeAnswerRepository rangeAnswerRepository;

    /*
    Post Operations
     */
    @Override
    public RangeAnswer saveRangeAnswer(RangeAnswer rangeAnswer) {
        return rangeAnswerRepository.save(rangeAnswer);
    }

    /*
    Get Operations
     */
    @Override
    public List<RangeAnswer> fetchAllRangeAnswer() {
        return (List<RangeAnswer>) rangeAnswerRepository.findAll();
    }

    @Override
    public Optional<RangeAnswer> fetchRangeAnswerById(Integer rangeAnswerId) {
        return rangeAnswerRepository.findById(rangeAnswerId);
    }

    /*
    Put Operations
     */

    /*
    Delete Operations
     */
}
