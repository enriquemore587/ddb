package com.persist.dao;

import java.util.List;

import com.persist.domain.UserAddress;

public interface UserAddressDao {
	
	public void save(UserAddress userAddress);
	public List<UserAddress> findAll();
	public UserAddress findById(Long id);
	
	public void closeSession();

}
