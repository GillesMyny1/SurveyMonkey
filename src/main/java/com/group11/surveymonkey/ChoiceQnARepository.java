package com.group11.surveymonkey;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ChoiceQnARepository extends PagingAndSortingRepository<ChoiceQnA, Integer>, CrudRepository<ChoiceQnA, Integer> {
}
