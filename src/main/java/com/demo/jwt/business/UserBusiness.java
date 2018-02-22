package com.demo.jwt.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.jwt.entity.AppUser;
import com.demo.jwt.ibusiness.IUserBusiness;
import com.demo.jwt.repo.AppUserRepository;

@Service
@Transactional
public class UserBusiness implements IUserBusiness{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Override
	public AppUser saveUser(AppUser user) {
		// TODO Auto-generated method stub
		String hashPass =bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPass);
		
		return appUserRepository.save(user);
	}

	@Override
	public AppUser findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return appUserRepository.findByUsername(username);
	}

	
}
