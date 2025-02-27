package com.workjunctionn.Service;

import java.util.List;
import java.util.Optional;

import com.workjunctionn.Entity.JobSeeker;

public interface JobSeekerService {

    public Optional<JobSeeker> getJobSeekerById(long jobseekerId);
    
    public List<JobSeeker> getAllJobSeeker();
    
	JobSeeker saveJobSeeker(JobSeeker jobSeekers);
	
	void updateJobSeekerById(JobSeeker jobSeeker, long jobseekerId);
	
	 void  deleteJobSeekerById(long jobseekerId);

}
