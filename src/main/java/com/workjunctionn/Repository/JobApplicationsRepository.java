package com.workjunctionn.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.workjunctionn.Entity.JobApplications;

public interface JobApplicationsRepository extends JpaRepository<JobApplications, Long>{
	
	@Query("SELECT SUM(jobapplicationId) FROM JobApplications")
	int totalId();

}
