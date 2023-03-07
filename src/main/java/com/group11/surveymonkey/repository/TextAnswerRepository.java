package com.group11.surveymonkey.repository;

import com.group11.surveymonkey.entity.TextAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TextAnswerRepository extends PagingAndSortingRepository<TextAnswer, Integer>, CrudRepository<TextAnswer, Integer> {
}
