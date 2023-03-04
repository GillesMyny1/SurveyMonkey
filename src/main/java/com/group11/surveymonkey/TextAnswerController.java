package com.group11.surveymonkey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class TextAnswerController {
    @Autowired
    private TextAnswerService textAnswerService;

    @PostMapping("/textAnswer")
    public TextAnswer saveTextAnswer(@RequestBody TextAnswer textAnswer) {
        return textAnswerService.saveTextAnswer(textAnswer);
    }

    @GetMapping("/textAnswer")
    public List<TextAnswer> fetchAllTextAnswer() {
        return textAnswerService.fetchAllTextAnswer();
    }

    @GetMapping("/textAnswer/{textAnswerId}")
    public Optional<TextAnswer> fetchTextAnswerById(@PathVariable("textAnswerId") Integer textAnswerId) {
        return textAnswerService.fetchTextAnswerById(textAnswerId);
    }
}
