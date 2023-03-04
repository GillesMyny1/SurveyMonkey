package com.group11.surveymonkey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ChoiceQnAController {
    @Autowired
    private ChoiceQnAService choiceQnAService;

    @PostMapping("/choiceQnA")
    public ChoiceQnA saveChoiceQnA(@RequestBody ChoiceQnA choiceQnA) {
        return choiceQnAService.saveChoiceQnA(choiceQnA);
    }

    @GetMapping("/choiceQnA")
    public List<ChoiceQnA> fetchAllChoiceQnA() {
        return choiceQnAService.fetchAllChoiceQnA();
    }

    @GetMapping("/choiceQnA/{QnAid}")
    public Optional<ChoiceQnA> fetchChoiceQnAById(@PathVariable("QnAid") Integer choiceQnAId) {
        return choiceQnAService.fetchChoiceQnAById(choiceQnAId);
    }

    @PutMapping("/choiceQnA/{QnAId}")
    public void addAnswerToChoiceQnA(@PathVariable("QnAId") Integer choiceQnAId, @RequestBody ChoiceAnswer choiceAnswer) {
        choiceQnAService.addAnswerToChoiceQnA(choiceQnAId, choiceAnswer);
    }
}
