package com.workjunctionn.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workjunctionn.Entity.Jobs;

public interface JobsRepository extends JpaRepository<Jobs, Long> {
	
	Optional<Jobs> getJobByJobTitle(String jobTitle);

	Optional<Jobs> getJobStatusByisActive(boolean isActive);


}
