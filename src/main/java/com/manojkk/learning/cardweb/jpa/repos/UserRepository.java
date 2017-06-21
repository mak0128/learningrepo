package com.manojkk.learning.cardweb.jpa.repos;

import org.springframework.data.repository.Repository;

import com.manojkk.learning.cardweb.jpa.entity.User;

public interface UserRepository extends Repository<User, Long> {
	public User findByUsername(String username); 
}
