package com.demo.jwt.business;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.jwt.entity.AppUser;
import com.demo.jwt.ibusiness.IUserBusiness;

@Service
public class UserDetailsBusiness implements UserDetailsService {

	@Autowired
	private IUserBusiness  userBusiness;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser u=userBusiness.findUserByUsername(username);
		if(u==null) throw new UsernameNotFoundException(username);
		
		
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		u.getRoles().forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.getRole()));
		});
		
		return new User(u.getUsername(),u.getPassword(),authorities) ;
	}

}
