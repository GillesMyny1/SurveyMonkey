package com.group11.surveymonkey;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ChoiceAnswerRepository extends PagingAndSortingRepository<ChoiceAnswer, Integer>, CrudRepository<ChoiceAnswer, Integer> {
}
