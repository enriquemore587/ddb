package com.persist.service;

import java.util.List;

import org.hibernate.Session;

import com.persist.dao.UserAddressDao;
import com.persist.dao.UserAddressDaoImpl;
import com.persist.domain.UserAddress;

public class UserAddressService implements UserAddressDao {
	private UserAddressDao userAddressDao;

	public UserAddressService(Session session) {
		this.userAddressDao = new UserAddressDaoImpl(session);
	}

	public void save(UserAddress userAddress) {
		this.userAddressDao.save(userAddress);
	}

	public List<UserAddress> findAll() {
		return this.userAddressDao.findAll();
	}

	public UserAddress findById(Long id) {
		return this.userAddressDao.findById(id);
	}

	public void closeSession() {
		this.userAddressDao.closeSession();
	}

}
