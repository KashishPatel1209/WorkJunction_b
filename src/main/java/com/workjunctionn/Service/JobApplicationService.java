package com.workjunctionn.Service;

import java.util.List;
import java.util.Optional;

import com.workjunctionn.Entity.JobApplications;

public interface JobApplicationService {
	 JobApplications saveJobApplications(JobApplications jobApplications);
		
		public List<JobApplications> getAllJobApplications();
		
		public Optional<JobApplications> getJobApplicationsById(long jobapplicationId);
		
		void  updateJobApplications(JobApplications jobApplications , long jobapplicationId);
		
		void deleteJobApplicationsById(long jobapplicationId);
	

}
