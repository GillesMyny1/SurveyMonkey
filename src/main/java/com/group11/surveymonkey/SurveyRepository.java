package com.group11.surveymonkey;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SurveyRepository extends PagingAndSortingRepository<Survey, Integer>, CrudRepository<Survey, Integer> {
}
