package com.persist.dao;

import java.util.List;

import com.persist.domain.TypeUser;

/**
 * @author Jose Enrique Vergara
 *
 */
public interface TypeUserDao {

	public void save(TypeUser typeUser);
	public List<TypeUser> findAll();
	public TypeUser findById(Long id);
	
	public void closeSession();

}
