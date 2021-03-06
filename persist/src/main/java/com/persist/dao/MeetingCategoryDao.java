package com.persist.dao;

import java.util.List;

import com.persist.domain.MeetingCategory;

/**
 * @author Jose Enrique Vergara
 *
 */
public interface MeetingCategoryDao {
	
	public void save(MeetingCategory meetingCategory);
	public List<MeetingCategory> findAll();
	public MeetingCategory findById(Long id);
	
	public void closeSession();

}
