package com.demo.jwt.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.jwt.entity.AppRole;
import com.demo.jwt.ibusiness.IRoleBusiness;
import com.demo.jwt.repo.AppRoleRepository;

@Service
@Transactional
public class RoleBusiness implements IRoleBusiness {

	@Autowired
	private AppRoleRepository appRoleRepository;
	
	
	@Override
	public AppRole saveRole(AppRole role) {
		// TODO Auto-generated method stub
		return appRoleRepository.save(role);
	}

	

}
