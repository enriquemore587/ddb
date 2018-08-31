package com.persist.dao;

import java.util.List;

import com.persist.domain.Profile;

/**
 * @author Jose Enrique Vergara
 *
 */
public interface ProfileDao {
	
	public void save(Profile profile);
	public List<Profile> findAll();
	public Profile findById(Long id);
	
	public void closeSession();

}
