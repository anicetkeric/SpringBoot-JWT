package com.demo.jwt.ibusiness;

import com.demo.jwt.entity.AppUser;

public interface IUserBusiness {

	public AppUser saveUser(AppUser user);
	public AppUser findUserByUsername(String username);
	
}
