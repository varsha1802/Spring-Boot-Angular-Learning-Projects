package com.example.demo.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.jwt.source.User;
import com.example.demo.jwt.source.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	/*	
	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  		static {
		    inMemoryUserList.add(new JwtUserDetails(1L, "varsha",
		        "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
		    inMemoryUserList.add(new JwtUserDetails(1L, "sample",
		            "$2a$10$DKucy5X5p7nhwuf6VwPdNOaNi3cE9nAVQJGMll0XtRZpaOsv6pkBS", "ROLE_USER_2"));
		}

  	@Override
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
	        .filter(user -> user.getUsername().equals(username)).findFirst();

	    if (!findFirst.isPresent()) {
	      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
	    }

	    return findFirst.get();
	  }
	 */
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{		
		User user = repo.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("User not found");		

		return new JwtUserDetails(user);
	}
}
