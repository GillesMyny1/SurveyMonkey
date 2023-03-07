package com.group11.surveymonkey.controller;

import java.util.*;

import com.group11.surveymonkey.service.SurveyService;
import com.group11.surveymonkey.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @PostMapping("/survey")
    public Survey saveSurvey(){
        return surveyService.saveSurvey(new Survey());
    }

    @GetMapping("/survey")
    public List<Survey> fetchAllSurvey() {
        return surveyService.fetchAllSurvey();
    }

    @GetMapping({"/survey/{surveyId}"})
    public Optional<Survey> getSurvey(@PathVariable("surveyId") Integer surveyId) {
        return surveyService.fetchSurveyById(surveyId);
    }
}
