package com.group11.surveymonkey;

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

    @GetMapping("/textAnswer")
    public List<ChoiceAnswer> fetchAllChoiceAnswer() {
        return choiceAnswerService.fetchAllChoiceAnswer();
    }

    @GetMapping("/textAnswer/{textAnswerId}")
    public Optional<ChoiceAnswer> fetchChoiceAnswerById(@PathVariable("choiceAnswerId") Integer choiceAnswerId) {
        return choiceAnswerService.fetchChoiceAnswerById(choiceAnswerId);
    }
}
