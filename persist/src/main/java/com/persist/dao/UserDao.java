package com.persist.dao;

import java.util.List;

import com.persist.domain.User;

public interface UserDao {
	
	public void save(User user);
	public User findById(Long id);

}
