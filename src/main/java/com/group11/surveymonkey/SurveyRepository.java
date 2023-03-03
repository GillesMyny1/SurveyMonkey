package com.group11.surveymonkey;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "survey", path = "survey")

public interface SurveyRepository extends CrudRepository<Survey, Integer>{
}
