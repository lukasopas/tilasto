package com.example.Tilasto.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Tilasto.domain.AppUser;
import com.example.Tilasto.domain.AppUserRepository;


@Service
public class UserDetailServiceImpl implements UserDetailsService  {
	private static final Logger log = LoggerFactory.getLogger(UserDetailServiceImpl.class);
	private final AppUserRepository repository;

	@Autowired
	public UserDetailServiceImpl(AppUserRepository userRepository) {
		this.repository = userRepository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {   
    	AppUser curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole()));
        
		 log.info("Trying to authenticate user: {}", username);
     //   log.info("Entered Password: {}", enteredPassword);
        //log.info("Stored Hashed Password: {}", storedHashedPassword);
        return user;
    }   
} 