package com.persist.dao;

import java.util.List;

import com.persist.domain.User;

public interface UserDao {
	
	public void save(User user);
	public List<User> findAll();
	public User findById(Long id);
	
	public void closeSession();
}
