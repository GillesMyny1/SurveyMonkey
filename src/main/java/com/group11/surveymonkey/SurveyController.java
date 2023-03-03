package com.group11.surveymonkey;


import java.util.List;
import java.util.Optional;
import org.example.SurveyRepository;
import org.example.BuddyInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SurveyController {
    @Autowired
    private SurveyRepository surveyService;

    @PostMapping("/survey")
    public Survey saveAddressBook(){
        return surveyService.save(new Survey());
    }

    @GetMapping({"/survey/{id}"})
    public Optional<Survey> getAddressBookList(@PathVariable("id") int id) {
        return surveyService.findById(id);
    }

    @PutMapping({"/survey/{id}/newQuestion"})
    public String addBuddy(@RequestParam("qid") Integer QuestionId, @PathVariable("id") int id, @RequestParam("type") int questionType) {
        if (questionType==0){
            TextQnA newQuestion = new TextQnA;
            surveyService.findById(id).ifPresent(x-> x.addTextQnA(newQuestion));
        }else if (questionType==1){
            RangeQnA newQuestion = new RangeQnA;
            surveyService.findById(id).ifPresent(x-> x.addRangeQnA(newQuestion));
        }else{
            ChoiceQnA newQuestion = new ChoiceQnA;
            surveyService.findById(id).ifPresent(x-> x.addChoiceQnA(newQuestion));
        }
        surveyService.findById(id).ifPresent(x-> surveyService.save(x));
        return "Added successfully";
    }
}
