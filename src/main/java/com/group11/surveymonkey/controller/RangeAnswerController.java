package com.group11.surveymonkey.controller;

import com.group11.surveymonkey.service.RangeAnswerService;
import com.group11.surveymonkey.entity.RangeAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class RangeAnswerController {
    @Autowired
    private RangeAnswerService rangeAnswerService;

    @PostMapping("/rangeAnswer")
    public RangeAnswer saveRangeAnswer(@RequestBody RangeAnswer rangeAnswer) {
        return rangeAnswerService.saveRangeAnswer(rangeAnswer);
    }

    @GetMapping("/rangeAnswer")
    public List<RangeAnswer> fetchAllRangeAnswer() {
        return rangeAnswerService.fetchAllRangeAnswer();
    }

    @GetMapping("/rangeAnswer/{rangeAnswerId}")
    public Optional<RangeAnswer> fetchRangeAnswerById(@PathVariable("rangeAnswerId") Integer rangeAnswerId) {
        return rangeAnswerService.fetchRangeAnswerById(rangeAnswerId);
    }
}
