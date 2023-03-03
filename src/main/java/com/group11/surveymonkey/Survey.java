package com.group11.surveymonkey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id = null;
    private String surveyName;
    @OneToMany
    private List<TextQnA> textList;

    @OneToMany
    private List<RangeQnA> rangeList;

    @OneToMany
    private List<ChoiceQnA> choiceList;

    public Survey(){}
    public Survey(String surveyName){
        this.surveyName = surveyName;
    }
    public void addTextQnA(TextQnA newQuestion){
        this.textList.add(newQuestion);
    }
    public void setTextList(List<TextQnA> newQuestionList){
        this.textList=newQuestionList;
    }

    public void addRangeQnA(RangeQnA newQuestion){
        this.rangeList.add(newQuestion);
    }
    public void setRangeList(List<RangeQnA> newQuestionList){
        this.rangeList=newQuestionList;
    }

    public void addChoiceQnA(ChoiceQnA newQuestion){
        this.choiceList.add(newQuestion);
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
