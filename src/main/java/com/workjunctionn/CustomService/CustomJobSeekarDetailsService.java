package com.workjunctionn.CustomService;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.workjunctionn.CustomService.GrantedAuthority;
import com.workjunctionn.CustomService.SimpleGrantedAuthority;
import com.workjunctionn.CustomService.UserDetails;
import com.workjunctionn.CustomService.UsernameNotFoundException;
import com.workjunctionn.Entity.JobSeeker;
import com.workjunctionn.Repository.JobSeekerRepository;

@Service
public class CustomJobSeekarDetailsService implements UserDetailsService {
	
	 private JobSeekerRepository jobSeekerRepository;

	    public CustomJobSeekerDetailsService(JobSeekerRepository jobSeekerRepository) {
	        this.jobSeekerRepository = jobSeekerRepository;
	    }

	    @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    	JobSeeker jobSeeker = jobSeekerRepository.findByEmail(email)
	               .orElseThrow(() ->
	                       new UsernameNotFoundException("User not found with email:" + email));
	        return new org.springframework.security.core.userdetails.User(jobSeeker.getEmail(),
	        		jobSeeker.getPassword(), mapRolesToAuthorities(jobSeeker.getRoles()));
	    }

	    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<com.workjunctionn.Entity.Role> roles){
	        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	    }

}
