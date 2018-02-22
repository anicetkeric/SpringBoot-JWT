package com.demo.jwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.jwt.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {

	public AppUser findByUsername(String username);
}
