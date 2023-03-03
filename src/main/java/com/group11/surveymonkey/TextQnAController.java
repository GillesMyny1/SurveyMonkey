package com.group11.surveymonkey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class TextQnAController {
    @Autowired
    private TextQnAService textQnAService;

    @PostMapping("/textQnA")
    public TextQnA saveTextQnA(@RequestBody TextQnA textQnA) {
        return textQnAService.saveTextQnA(textQnA);
    }

    @GetMapping("/textQnA")
    public List<TextQnA> fetchAllTextQnA() {
        return textQnAService.fetchAllTextQnA();
    }

    @GetMapping("/textQnA/{id}")
    public Optional<TextQnA> fetchTextQnAById(@PathVariable("id") Integer textQnAId) {
        return textQnAService.fetchTextQnAById(textQnAId);
    }

    @PutMapping("/textQnA/{QnAId}")
    public void addAnswerToTextQnA(@PathVariable("QnAId") Integer textQnAId, @RequestBody TextAnswer textAnswer) {
        textQnAService.addAnswerToTextQnA(textQnAId, textAnswer);
    }
}
