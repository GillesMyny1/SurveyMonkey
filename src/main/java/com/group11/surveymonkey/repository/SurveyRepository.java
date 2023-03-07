package com.group11.surveymonkey.repository;

import com.group11.surveymonkey.entity.Survey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SurveyRepository extends PagingAndSortingRepository<Survey, Integer>, CrudRepository<Survey, Integer> {
}
