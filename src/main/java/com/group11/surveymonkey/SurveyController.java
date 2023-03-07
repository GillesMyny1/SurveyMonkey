package com.group11.surveymonkey;

import java.util.*;
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

    /*
    @PutMapping({"/survey/{surveyId}/newQuestion"})
    public String addQuestion(@RequestParam("qid") Integer QuestionId, @PathVariable("surveyId") Integer surveyId, @RequestParam("type") int questionType) {
        if (questionType==0){
            TextQnA newQuestion = new TextQnA();
            surveyService.findById(id).ifPresent(x-> x.addTextQnA(newQuestion));
        }else if (questionType==1){
            RangeQnA newQuestion = new RangeQnA();
            surveyService.findById(id).ifPresent(x-> x.addRangeQnA(newQuestion));
        }else{
            ChoiceQnA newQuestion = new ChoiceQnA();
            surveyService.findById(id).ifPresent(x-> x.addChoiceQnA(newQuestion));
        }
        surveyService.findById(id).ifPresent(x-> surveyService.save(x));
        return "Added successfully";
    }
    */
}
