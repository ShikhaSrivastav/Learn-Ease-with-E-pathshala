package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	User findById(int id);
}
