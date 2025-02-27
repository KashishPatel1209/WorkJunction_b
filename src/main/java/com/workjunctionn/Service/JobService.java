package com.workjunctionn.Service;

import java.util.List;
import java.util.Optional;

import com.workjunctionn.Entity.Jobs;

public interface JobService {
	public List<Jobs> getAllJobs();
	void deleteJobById(long jobId);
	Jobs saveJobs(Jobs  jobs);
	void updateJobs(Jobs jobs, long jobId);
	public Optional<Jobs> getJobById(long jobId);
	Optional<Jobs> getJobByJobTitle(String job_title );

}
