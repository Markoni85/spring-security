package org.codehustler.security;
 
import java.util.Arrays;
import java.util.List;

import org.codehustler.dao.UserModel;
import org.codehustler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
 
@Component
public class LoginService implements UserDetailsService
{
	@Autowired
	private UserService userService;
 
 
    public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException
    {
        UserModel user = userService.findByUsername( username );
 
        if( user == null )
            throw new UsernameNotFoundException( "Oops!" );
 
        List<SimpleGrantedAuthority> authorities = Arrays.asList( new SimpleGrantedAuthority( user.getRole() ) );
 
		return new User(user.getUsername(), user.getPassword(), authorities );
    }
}