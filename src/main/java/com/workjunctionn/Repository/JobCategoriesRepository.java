package com.workjunctionn.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workjunctionn.Entity.JobCategories;

public interface JobCategoriesRepository extends JpaRepository<JobCategories, Long>{
	
	Optional<JobCategories> getJobByCategoryName(long categoryName);


}
