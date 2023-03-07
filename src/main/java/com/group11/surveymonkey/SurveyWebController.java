package com.group11.surveymonkey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class SurveyWebController {
    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private ChoiceQnARepository choiceQnARepository;

    @Autowired
    private RangeQnARepository rangeQnARepository;

    @Autowired
    private TextQnARepository textQnARepository;

    @RequestMapping("/survey")
    public String displaySurvey(Model model) {
        model.addAttribute("surveys", surveyRepository.findAll());
        model.addAttribute("textQnAs", textQnARepository.findAll());
        model.addAttribute("choiceQnAs", choiceQnARepository.findAll());
        model.addAttribute("rangeQnAs", rangeQnARepository.findAll());
        return "displaySurvey";
    }

    @GetMapping("/createSurvey")
    public String getSurvey(Model model) {
        model.addAttribute("newSurvey", surveyRepository.findAll());
        return "createdSurvey";
    }

    @PostMapping("/createSurvey")
    public String addSurvey() {
        Survey survey = new Survey;
        surveyRepository.save(survey);
        return "survey";
    }

    @GetMapping("/createTextQnA")
    public String getTextQnA(Model model) {
        model.addAttribute("textQnA", new TextQnA());
        return "createdTextQnA";
    }

    @PostMapping("/createTextQnA")
    public String addTextQnA(@ModelAttribute TextQnA textQnA, Model model) {
        model.addAttribute("textQnA", textQnA);
        textQnARepository.save(textQnA);
        return "survey";
    }

    @GetMapping("/createChoiceQnA")
    public String getChoiceQnA(Model model) {
        model.addAttribute("choiceQnA", new ChoiceQnA());
        return "createdChoiceQnA";
    }

    @PostMapping("/createChoiceQnA")
    public String addChoiceQnA(@ModelAttribute ChoiceQnA choiceQnA, Model model) {
        model.addAttribute("choiceQnA", choiceQnA);
        choiceQnARepository.save(choiceQnA);
        return "survey";
    }

    @GetMapping("/createRangeQnA")
    public String getRangeQnA(Model model) {
        model.addAttribute("rangeQnA", new RangeQnA());
        return "createdRangeQnA";
    }

    @PostMapping("/createRangeQnA")
    public String addRangeQnA(@ModelAttribute RangeQnA rangeQnA, Model model) {
        model.addAttribute("rangeQnA", rangeQnA);
        textQnARepository.save(rangeQnA);
        return "survey";
    }

    @GetMapping("/addQnAToSurvey")
    public String getTextQnAToSurvey(Model model) {
        model.addAttribute("surveys", surveyRepository.findAll());
        return "addQnAToSurvey";
    }

    @PostMapping("/addQnAToSurvey")
    public String addTextQnAToSurvey(@RequestParam("textId") Integer textQnAId, @RequestParam("choiceId") Integer choiceQnAId, @RequestParam("rangeId") Integer rangeQnAId, @RequestParam("surveyId") Integer surveyId) {
        Survey survey = surveyRepository.findById(surveyId);
        if(textQnAId != null) {
            TextQnA textQnA = textQnARepository.findById(textQnAId);
            survey.addTextQnA(textQnA);
        }
        if(choiceQnAId != null) {
            ChoiceQnA choiceQnA = choiceQnARepository.findById(choiceQnAId);
            survey.addChoiceQnA(choiceQnA);
        }
        if(rangeQnAId != null) {
            RangeQnA rangeQnA = rangeQnARepository.findById(rangeQnAId);
            survey.addRangeQnA(rangeQnA);
        }
        surveyRepository.save(survey);
        return "survey";
    }
}
