package com.group11.surveymonkey.repository;

import com.group11.surveymonkey.entity.ChoiceQnA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ChoiceQnARepository extends PagingAndSortingRepository<ChoiceQnA, Integer>, CrudRepository<ChoiceQnA, Integer> {
}
