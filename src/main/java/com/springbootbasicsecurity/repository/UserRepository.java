package com.springbootbasicsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootbasicsecurity.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUsername(String userName);

}
