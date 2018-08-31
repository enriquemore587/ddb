package com.persist.dao;

import java.util.List;

import com.persist.domain.User;

/**
 * @author Jose Enrique Vergara
 *
 */
public interface UserDao {
	
	public void save(User user);
	public List<User> findAll();
	public User findById(Long id);
	
	public User findByUserName(String user_name);
	
	public void closeSession();
}
