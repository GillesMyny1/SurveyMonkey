package com.group11.surveymonkey;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TextAnswerRepository extends PagingAndSortingRepository<TextAnswer, Integer>, CrudRepository<TextAnswer, Integer> {
}
