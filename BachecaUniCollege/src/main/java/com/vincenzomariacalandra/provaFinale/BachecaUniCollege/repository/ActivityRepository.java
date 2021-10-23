package com.vincenzomariacalandra.provaFinale.BachecaUniCollege.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vincenzomariacalandra.provaFinale.BachecaUniCollege.model.Activity;
import com.vincenzomariacalandra.provaFinale.BachecaUniCollege.utility.ActivityType;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {

	Optional<Activity> findById(long id);
	
	List<Optional<Activity>> findByTitle(String title);
	
	Iterable<Activity> findByState(boolean state);

	List<Activity> findAllByActivityTypeAndState(ActivityType tertuliaATema, Boolean state);
}