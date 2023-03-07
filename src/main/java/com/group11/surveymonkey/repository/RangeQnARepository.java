package com.group11.surveymonkey.repository;

import com.group11.surveymonkey.entity.RangeQnA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RangeQnARepository extends PagingAndSortingRepository<RangeQnA, Integer>, CrudRepository<RangeQnA, Integer> {
}
