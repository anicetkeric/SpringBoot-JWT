package com.demo.jwt.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class AppUser {

	@Id @GeneratedValue
    private Long id;
  private String password;
  private String username;
  
  @ManyToMany(fetch =FetchType.EAGER)
  private Collection<AppRole> roles=new ArrayList<>();
  
  




public AppUser(Long id, String password, String username, Collection<AppRole> roles) {
	super();
	this.id = id;
	this.password = password;
	this.username = username;
	this.roles = roles;
}



public AppUser() {
	super();
	// TODO Auto-generated constructor stub
}



public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}



public Collection<AppRole> getRoles() {
	return roles;
}



public void setRoles(Collection<AppRole> roles) {
	this.roles = roles;
}
  
  
  
}
