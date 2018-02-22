package com.demo.jwt.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jwt.entity.AppUser;
import com.demo.jwt.entity.Task;
import com.demo.jwt.ibusiness.IUserBusiness;
import com.demo.jwt.repo.TaskRepository;

@RestController
@RequestMapping("/api")
public class TestRestController {
	
	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
    private IUserBusiness applicationUserRepository;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    

    @PostMapping("/sign-up")
    public AppUser signUp(@RequestBody AppUser user) {
    	System.out.println("*****************");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return applicationUserRepository.saveUser(user);
    }
   
	
	@GetMapping("/tasks")
	public List<Task> listTask()
	{
		return taskRepo.findAll();
	}
	
	
	@PostMapping("/tasks")
	public Task save(@RequestBody Task t)
	{
		return taskRepo.save(t);
	}

}
