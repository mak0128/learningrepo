package com.manojkk.learning.cardweb.security.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.manojkk.learning.cardweb.jpa.entity.Authority;
import com.manojkk.learning.cardweb.jpa.entity.User;
import com.manojkk.learning.cardweb.jpa.repos.UserRepository;

public class MyUserDetailService implements UserDetailsService {
	
	private Logger logger = Logger.getLogger(MyUserDetailService.class);
	
	@Autowired
	private UserRepository userRepos;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		logger.info("Enter into loadUserByUsername ::"+name);
		
		User user = userRepos.findByUsername(name);
		
		logger.info("Found user in DB ::"+user.getEnabled()+", authorities : "+user.getAuthorities());

		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(user.getAuthorities().size());

		for (Authority authority : user.getAuthorities()) {
			authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}

}
