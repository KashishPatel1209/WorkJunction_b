package com.workjunctionn.Service;

import java.util.List;
import java.util.Optional;

import com.workjunctionn.Entity.Recruiters;

public interface RecruiterService {

	Recruiters createRecruiters(Recruiters  recruiters);
	
    void deleteRecruiterById(long recruiterId);
    
    void updateRecruiterById(Recruiters recruiters , long recruiterId);
    
    public Optional<Recruiters> getRecruitersById(long recruiterId);
    
    public List<Recruiters> getAllRecruiters();

}
