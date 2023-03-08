package com.group11.surveymonkey.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id = null;
    private String surveyName;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "id")
    private List<TextQnA> textList;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "id")
    private List<RangeQnA> rangeList;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "id")
    private List<ChoiceQnA> choiceList;

    public Survey() {
        this.textList = new ArrayList<>();
        this.rangeList = new ArrayList<>();
        this.choiceList = new ArrayList<>();
    }
    public Survey(String surveyName) {
        this.textList = new ArrayList<>();
        this.rangeList = new ArrayList<>();
        this.choiceList = new ArrayList<>();
        this.surveyName = surveyName;
    }

    public void addTextQnA(TextQnA newQuestion){
        this.textList.add(newQuestion);
    }

    public void addChoiceQnA(ChoiceQnA newQuestion){
        this.choiceList.add(newQuestion);
    }

    public void addRangeQnA(RangeQnA newQuestion){
        this.rangeList.add(newQuestion);
    }

    public List<TextQnA> getTextList() {
        return this.textList;
    }

    public void setTextList(List<TextQnA> newQuestionList){
        this.textList=newQuestionList;
    }

    public List<RangeQnA> getRangeList() {
        return this.rangeList;
    }

    public void setRangeList(List<RangeQnA> newQuestionList){
        this.rangeList=newQuestionList;
    }

    public List<ChoiceQnA> getChoiceList() {
        return this.choiceList;
    }

    public void setChoiceList(List<ChoiceQnA> newQuestionList){
        this.choiceList=newQuestionList;
    }

    public Integer getSurveyID(){
        return this.id;
    }
    public void setSurveyID(Integer i){
        this.id=i;
    }
    public String getSurveyName(){
        return this.surveyName;
    }
    public void setSurveyName(String surveyName){
        this.surveyName = surveyName;
    }
}
