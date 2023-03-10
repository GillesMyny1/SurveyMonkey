package com.group11.surveymonkey.controller;

import com.group11.surveymonkey.service.ChoiceAnswerService;
import com.group11.surveymonkey.entity.ChoiceAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ChoiceAnswerController {
    @Autowired
    private ChoiceAnswerService choiceAnswerService;

    @PostMapping("/choiceAnswer")
    public ChoiceAnswer saveChoiceAnswer(@RequestBody ChoiceAnswer choiceAnswer) {
        return choiceAnswerService.saveChoiceAnswer(choiceAnswer);
    }

    @GetMapping("/choiceAnswer")
    public List<ChoiceAnswer> fetchAllChoiceAnswer() {
        return choiceAnswerService.fetchAllChoiceAnswer();
    }

    @GetMapping("/choiceAnswer/{choiceAnswerId}")
    public Optional<ChoiceAnswer> fetchChoiceAnswerById(@PathVariable("choiceAnswerId") Integer choiceAnswerId) {
        return choiceAnswerService.fetchChoiceAnswerById(choiceAnswerId);
    }
}
