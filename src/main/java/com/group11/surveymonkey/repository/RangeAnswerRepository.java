package com.group11.surveymonkey.repository;

import com.group11.surveymonkey.entity.RangeAnswer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RangeAnswerRepository extends PagingAndSortingRepository<RangeAnswer, Integer>, CrudRepository<RangeAnswer, Integer> {
}
