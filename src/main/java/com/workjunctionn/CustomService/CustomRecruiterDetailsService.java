package com.workjunctionn.CustomService;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.workjunctionn.CustomService.GrantedAuthority;
import com.workjunctionn.CustomService.SimpleGrantedAuthority;
import com.workjunctionn.CustomService.UserDetails;
import com.workjunctionn.CustomService.UserDetailsService;
import com.workjunctionn.CustomService.UsernameNotFoundException;
import com.workjunctionn.Entity.Recruiters;
import com.workjunctionn.Entity.Role;
import com.workjunctionn.Repository.RecruitersRepository;


@Service
public class CustomRecruiterDetailsService implements UserDetailsService {
	
	 private RecruitersRepository recruiterRepository;

	    public CustomRecruiterDetailsService(RecruitersRepository recruiterRepository) {
	        this.recruiterRepository = recruiterRepository;
	    }

	    @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    	Recruiters recruiter = recruiterRepository.findByEmail(email)
	               .orElseThrow(() ->
	                       new UsernameNotFoundException("User not found with email:" + email));
	        return new org.springframework.security.core.userdetails.User(recruiter.getEmail(),
	        		recruiter.getRecruiterPassword(), mapRolesToAuthorities(recruiter.getRoles()));
	    }

	    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles){
	        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	    }

}
