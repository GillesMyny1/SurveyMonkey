package com.group11.surveymonkey.controller;

import java.util.*;

import com.group11.surveymonkey.entity.TextQnA;
import com.group11.surveymonkey.service.SurveyService;
import com.group11.surveymonkey.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @PostMapping("/survey")
    public Survey saveSurvey(@RequestBody Survey survey){
        return surveyService.saveSurvey(survey);
    }

    @GetMapping("/survey")
    public List<Survey> fetchAllSurvey() {
        return surveyService.fetchAllSurvey();
    }

    @GetMapping("/survey/{surveyId}")
    public Optional<Survey> getSurvey(@PathVariable("surveyId") Integer surveyId) {
        return surveyService.fetchSurveyById(surveyId);
    }

    @PutMapping("/survey/{surveyId}/{newSurveyName}")
    public Survey updateSurvey(@PathVariable("surveyId") Integer surveyId, @PathVariable("newSurveyName") String newSurveyName) {
        return surveyService.updateSurvey(surveyId, newSurveyName);
    }
}
