package com.group11.surveymonkey;

import com.group11.surveymonkey.entity.*;
import com.group11.surveymonkey.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.w3c.dom.Text;

import java.util.List;

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
    private final TextAnswerRepository textAnswerRepository;

    public SurveyWebController(TextAnswerRepository textAnswerRepository) {
        this.textAnswerRepository = textAnswerRepository;
    }

    @RequestMapping("/surveyHome")
    public String displaySurvey(Model model) {
        model.addAttribute("surveyList", surveyRepository.findAll());
        return "surveyDisplay";
    }

    @GetMapping("/createSurvey")
    public String surveyForm(Model model) {
        model.addAttribute("newSurvey", new Survey());
        return "surveyCreate";
    }

    @PostMapping("/saveSurvey")
    public String surveySubmit(Survey newSurvey) {
        surveyRepository.save(newSurvey);
        return "redirect:/surveyHome";
    }

    @GetMapping("/survey/{id}/addTextQuestion")
    public String textQnAForm(@PathVariable("id") Integer id, Model model) {
        Survey survey = surveyRepository.findById(id).get();
        TextQnA textQnA = new TextQnA();
        model.addAttribute("survey", survey);
        model.addAttribute("surveyId", id);
        model.addAttribute("textQnA", textQnA);
        return "textQnACreate";
    }

    @PostMapping("/saveTextQnA")
    public String textQnASubmit(TextQnA textQnA, @RequestParam("surveyId") Integer surveyId) {
        Survey survey = surveyRepository.findById(surveyId).get();
        survey.addTextQnA(textQnA);
        textQnARepository.save(textQnA);
        surveyRepository.save(survey);
        return "redirect:/surveyHome";
    }

    @GetMapping("/survey/{id}/addRangeQuestion")
    public String rangeQnAForm(@PathVariable("id") Integer id, Model model) {
        Survey survey = surveyRepository.findById(id).get();
        model.addAttribute("survey", survey);
        model.addAttribute("rangeQnA", new RangeQnA());
        return "rangeQnACreate";
    }

    @PostMapping("/saveRangeQnA")
    public String rangeQnASubmit(RangeQnA rangeQnA) {
        rangeQnARepository.save(rangeQnA);
        return "redirect:/surveyHome";
    }

    @GetMapping("/survey/{id}/addChoiceQuestion")
    public String choiceQnAForm(@PathVariable("id") Integer id, Model model) {
        Survey survey = surveyRepository.findById(id).get();
        model.addAttribute("survey", survey);
        model.addAttribute("choiceQnA", new ChoiceQnA());
        return "choiceQnACreate";
    }

    @PostMapping("/saveChoiceQnA")
    public String choiceQnASubmit(ChoiceQnA choiceQnA) {
        choiceQnARepository.save(choiceQnA);
        return "redirect:/surveyHome";
    }

    @GetMapping("/survey/{id}/viewQuestions")
    public String viewSurveyQuestions(@PathVariable("id") Integer id, Model model) {
        Survey survey = surveyRepository.findById(id).get();
        model.addAttribute("survey", survey);
        return "questionViewer";
    }

    @GetMapping("/answerTextQnA/{surveyId}/{QnAId}")
    public String addTextAnswerToTextQnA(@PathVariable("surveyId") Integer surveyId, @PathVariable("QnAId") Integer QnAId, Model model) {
        Survey survey = surveyRepository.findById(surveyId).get();
        TextQnA textQnA = textQnARepository.findById(QnAId).get();
        TextAnswer textAnswer = new TextAnswer();
        textAnswer.setTextQnA(textQnA);
        model.addAttribute("survey", survey);
        model.addAttribute("surveyId", surveyId);
        model.addAttribute("textQnA", textQnA);
        model.addAttribute("textQnAId", QnAId);
        model.addAttribute("textAnswer", textAnswer);
        return "textAnswerCreate";
    }

    @PostMapping("/saveTextAnswer")
    public String textAnswerSubmit(TextAnswer newTextAnswer, @RequestParam("surveyId") Integer surveyId, @RequestParam("textQnAId") Integer textQnAId) {
        Survey survey = surveyRepository.findById(surveyId).get();
        TextQnA textQnA = textQnARepository.findById(textQnAId).get();
        newTextAnswer.setTextQnA(textQnA);
        textQnA.addTextAnswer(newTextAnswer);
        textAnswerRepository.save(newTextAnswer);
        textQnARepository.save(textQnA);
        surveyRepository.save(survey);
        return "redirect:/surveyHome";
    }

    @GetMapping("/textQnA/{QnAId}/viewAnswers")
    public String viewTextQnAAnswers(@PathVariable("QnAId") Integer QnAId, Model model) {
        TextQnA textQnA = textQnARepository.findById(QnAId).get();
        List<TextAnswer> answers = textQnA.getTextAnswers();
        model.addAttribute("textQnA", textQnA);
        model.addAttribute("answers", answers);
        return "textAnswerViewer";
    }
}
