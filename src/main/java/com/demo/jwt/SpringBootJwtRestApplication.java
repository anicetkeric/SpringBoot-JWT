package com.demo.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.demo.jwt.entity.AppUser;
import com.demo.jwt.repo.AppUserRepository;

@SpringBootApplication
public class SpringBootJwtRestApplication implements CommandLineRunner  {

	@Autowired
	private AppUserRepository  appUserRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtRestApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		AppUser u=new AppUser();
		u.setUsername("demo");
		u.setPassword(bCryptPasswordEncoder.encode("demo"));
		u.setRoles(null);
		appUserRepository.save(u);
	}
}