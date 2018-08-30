package com.persist.dao;

import com.persist.domain.User;

public interface UserDao {
	
	public void save(User user);
	public User findById(Long id);

}
