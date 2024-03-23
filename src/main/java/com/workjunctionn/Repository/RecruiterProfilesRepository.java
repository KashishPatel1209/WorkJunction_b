package com.workjunctionn.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workjunctionn.Entity.RecruiterProfiles;

public interface RecruiterProfilesRepository extends JpaRepository<RecruiterProfiles, Long> {
	
	Optional<RecruiterProfiles> findByrecruiterprofileId(long recruiterprofileId);




}
