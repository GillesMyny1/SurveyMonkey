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

    @Autowired
    private TextAnswerRepository textAnswerRepository;

    @Autowired
    private RangeAnswerRepository rangeAnswerRepository;

    @Autowired
    private ChoiceAnswerRepository choiceAnswerRepository;

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

    @GetMapping("/editSurveyInfo/{id}")
    public String editSurveyForm(@PathVariable("id") Integer surveyId, Model model) {
        Survey survey = surveyRepository.findById(surveyId).get();
        model.addAttribute("survey", survey);
        return "editSurvey";
    }

    @PostMapping("/saveUpdatedSurvey")
    public String surveyInfoUpdate(@RequestParam("surveyId") Integer surveyId, @RequestParam String newSurveyName) {
        Survey survey = surveyRepository.findById(surveyId).get();
        survey.setSurveyName(newSurveyName);
        surveyRepository.save(survey);
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
        RangeQnA rangeQnA = new RangeQnA();
        model.addAttribute("survey", survey);
        model.addAttribute("surveyId", id);
        model.addAttribute("rangeQnA", rangeQnA);
        return "rangeQnACreate";
    }

    @PostMapping("/saveRangeQnA")
    public String rangeQnASubmit(RangeQnA rangeQnA, @RequestParam("surveyId") Integer surveyId) {
        Survey survey = surveyRepository.findById(surveyId).get();
        survey.addRangeQnA(rangeQnA);
        rangeQnARepository.save(rangeQnA);
        surveyRepository.save(survey);
        return "redirect:/surveyHome";
    }

    @GetMapping("/survey/{id}/addChoiceQuestion")
    public String choiceQnAForm(@PathVariable("id") Integer id, Model model) {
        Survey survey = surveyRepository.findById(id).get();
        ChoiceQnA choiceQnA = new ChoiceQnA();
        model.addAttribute("survey", survey);
        model.addAttribute("surveyId", id);
        model.addAttribute("choiceQnA", choiceQnA);
        return "choiceQnACreate";
    }

    @PostMapping("/saveChoiceQnA")
    public String choiceQnASubmit(ChoiceQnA choiceQnA, @RequestParam("surveyId") Integer surveyId) {
        Survey survey = surveyRepository.findById(surveyId).get();
        survey.addChoiceQnA(choiceQnA);
        choiceQnARepository.save(choiceQnA);
        surveyRepository.save(survey);
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

    @GetMapping("/answerRangeQnA/{surveyId}/{QnAId}")
    public String addRangeAnswerToRangeQnA(@PathVariable("surveyId") Integer surveyId, @PathVariable("QnAId") Integer QnAId, Model model) {
        Survey survey = surveyRepository.findById(surveyId).get();
        RangeQnA rangeQnA = rangeQnARepository.findById(QnAId).get();
        RangeAnswer rangeAnswer = new RangeAnswer();
        rangeAnswer.setRangeQnA(rangeQnA);
        model.addAttribute("survey", survey);
        model.addAttribute("surveyId", surveyId);
        model.addAttribute("rangeQnA", rangeQnA);
        model.addAttribute("rangeQnAId", QnAId);
        model.addAttribute("rangeAnswer", rangeAnswer);
        return "rangeAnswerCreate";
    }

    @PostMapping("/saveRangeAnswer")
    public String rangeAnswerSubmit(RangeAnswer newRangeAnswer, @RequestParam("surveyId") Integer surveyId, @RequestParam("rangeQnAId") Integer rangeQnAId) {
        Survey survey = surveyRepository.findById(surveyId).get();
        RangeQnA rangeQnA = rangeQnARepository.findById(rangeQnAId).get();
        newRangeAnswer.setRangeQnA(rangeQnA);
        rangeQnA.addRangeAnswer(newRangeAnswer);
        rangeAnswerRepository.save(newRangeAnswer);
        rangeQnARepository.save(rangeQnA);
        surveyRepository.save(survey);
        return "redirect:/surveyHome";
    }

    @GetMapping("/rangeQnA/{QnAId}/viewAnswers")
    public String viewRangeQnAAnswers(@PathVariable("QnAId") Integer QnAId, Model model) {
        RangeQnA rangeQnA = rangeQnARepository.findById(QnAId).get();
        List<RangeAnswer> answers = rangeQnA.getRangeAnswers();
        model.addAttribute("rangeQnA", rangeQnA);
        model.addAttribute("answers", answers);
        return "rangeAnswerViewer";
    }

    @GetMapping("/answerChoiceQnA/{surveyId}/{QnAId}")
    public String addChoiceAnswerToChoiceQnA(@PathVariable("surveyId") Integer surveyId, @PathVariable("QnAId") Integer QnAId, Model model) {
        Survey survey = surveyRepository.findById(surveyId).get();
        ChoiceQnA choiceQnA = choiceQnARepository.findById(QnAId).get();
        ChoiceAnswer choiceAnswer = new ChoiceAnswer();
        choiceAnswer.setChoiceQnA(choiceQnA);
        model.addAttribute("survey", survey);
        model.addAttribute("surveyId", surveyId);
        model.addAttribute("choiceQnA", choiceQnA);
        model.addAttribute("choiceQnAId", QnAId);
        model.addAttribute("choiceAnswer", choiceAnswer);
        return "choiceAnswerCreate";
    }

    @PostMapping("/saveChoiceAnswer")
    public String choiceAnswerSubmit(ChoiceAnswer newChoiceAnswer, @RequestParam("surveyId") Integer surveyId, @RequestParam("choiceQnAId") Integer choiceQnAId) {
        Survey survey = surveyRepository.findById(surveyId).get();
        ChoiceQnA choiceQnA = choiceQnARepository.findById(choiceQnAId).get();
        newChoiceAnswer.setChoiceQnA(choiceQnA);
        choiceQnA.addChoiceAnswer(newChoiceAnswer);
        choiceAnswerRepository.save(newChoiceAnswer);
        choiceQnARepository.save(choiceQnA);
        surveyRepository.save(survey);
        return "redirect:/surveyHome";
    }

    @GetMapping("/choiceQnA/{QnAId}/viewAnswers")
    public String viewChoiceQnAAnswers(@PathVariable("QnAId") Integer QnAId, Model model) {
        ChoiceQnA choiceQnA = choiceQnARepository.findById(QnAId).get();
        List<ChoiceAnswer> answers = choiceQnA.getChoiceAnswers();
        model.addAttribute("choiceQnA", choiceQnA);
        model.addAttribute("answers", answers);
        return "choiceAnswerViewer";
    }
}
