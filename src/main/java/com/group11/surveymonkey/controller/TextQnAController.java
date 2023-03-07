package com.group11.surveymonkey.controller;

import com.group11.surveymonkey.service.TextQnAService;
import com.group11.surveymonkey.entity.TextAnswer;
import com.group11.surveymonkey.entity.TextQnA;
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

    @GetMapping("/textQnA/{QnAid}")
    public Optional<TextQnA> fetchTextQnAById(@PathVariable("QnAid") Integer textQnAId) {
        return textQnAService.fetchTextQnAById(textQnAId);
    }

    @PutMapping("/textQnA/{QnAId}")
    public void addAnswerToTextQnA(@PathVariable("QnAId") Integer textQnAId, @RequestBody TextAnswer textAnswer) {
        textQnAService.addAnswerToTextQnA(textQnAId, textAnswer);
    }
}