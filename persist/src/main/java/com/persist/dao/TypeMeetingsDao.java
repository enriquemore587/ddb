package com.persist.dao;

import java.util.List;

import com.persist.domain.TypeMeetings;

/**
 * @author Jose Enrique Vergara
 *
 */
public interface TypeMeetingsDao {
	
	public void save(TypeMeetings meetings);
	public List<TypeMeetings> findAll();
	public TypeMeetings findById(Long id);
	
	public void closeSession();

}
