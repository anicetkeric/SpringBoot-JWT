package com.demo.jwt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.jwt.entity.Task;


public interface TaskRepository extends JpaRepository<Task,Long> {

}
