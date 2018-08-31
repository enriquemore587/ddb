package com.persist.dao;

import java.util.List;

import com.persist.domain.CivilStatus;

/**
 * @author Jose Enrique Vergara
 *
 */
public interface CivilStatusDao {
	
	public void save(CivilStatus civilStatus);
	public List<CivilStatus> findAll();
	public CivilStatus findById(Long id);
	
	public void closeSession();
}
