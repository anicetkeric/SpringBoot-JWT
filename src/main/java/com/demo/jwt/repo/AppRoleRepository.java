package com.demo.jwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.jwt.entity.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {

	public AppRole findByRole(String role);
}
