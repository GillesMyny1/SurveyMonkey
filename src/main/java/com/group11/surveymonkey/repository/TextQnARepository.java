package com.group11.surveymonkey.repository;

import com.group11.surveymonkey.entity.TextQnA;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;

public interface TextQnARepository extends PagingAndSortingRepository<TextQnA, Integer>, CrudRepository<TextQnA, Integer> {
}
