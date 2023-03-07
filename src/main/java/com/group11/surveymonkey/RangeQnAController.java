package com.group11.surveymonkey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RangeQnAController {
    @Autowired
    private RangeQnAService rangeQnAService;

    @PostMapping("/rangeQnA")
    public RangeQnA saveRangeQnA(@RequestBody RangeQnA rangeQnA) {
        return rangeQnAService.saveRangeQnA(rangeQnA);
    }

    @GetMapping("/rangeQnA")
    public List<RangeQnA> fetchAllRangeQnA() {
        return rangeQnAService.fetchAllRangeQnA();
    }

    @GetMapping("/rangeQnA/{QnAid}")
    public Optional<RangeQnA> fetchRangeQnAById(@PathVariable("QnAid") Integer rangeQnAId) {
        return rangeQnAService.fetchRangeQnAById(rangeQnAId);
    }

    @PutMapping("/rangeQnA/{QnAId}")
    public void addAnswerToRangeQnA(@PathVariable("QnAId") Integer rangeQnAId, @RequestBody RangeAnswer rangeAnswer) {
        rangeQnAService.addAnswerToRangeQnA(rangeQnAId, rangeAnswer);
    }
}
