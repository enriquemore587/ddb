package com.persist.dao;

import java.util.List;

import com.persist.domain.UserPersonalData;

/**
 * @author Jose Enrique Vergara
 *
 */
public interface UserPersonalDataDao {
	
	public void save(UserPersonalData userPersonalData);
	public List<UserPersonalData> findAll();
	public UserPersonalData findById(Long id);
	
	public void closeSession();
}
