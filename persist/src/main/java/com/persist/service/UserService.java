package com.persist.service;

import java.util.List;

import org.hibernate.Session;

import com.persist.dao.UserDao;
import com.persist.dao.UserDaoImpl;
import com.persist.domain.User;

public class UserService implements UserDao {
	private UserDao userDao;

	public UserService(Session session) {
		this.userDao = new UserDaoImpl(session);
	}

	public void save(User user) {
		this.userDao.save(user);

	}

	public List<User> findAll() {
		return this.userDao.findAll();
	}

	public User findById(Long id) {
		return this.userDao.findById(id);
	}

	public void closeSession() {
		this.userDao.closeSession();
	}

}
