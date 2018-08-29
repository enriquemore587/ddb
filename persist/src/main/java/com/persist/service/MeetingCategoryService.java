package com.persist.service;

import java.util.List;

import org.hibernate.Session;

import com.persist.dao.MeetingCategoryDao;
import com.persist.dao.MeetingCategoryDaoImpl;
import com.persist.domain.MeetingCategory;

public class MeetingCategoryService implements MeetingCategoryDao {
	private MeetingCategoryDao meetingCategoryDao;

	public MeetingCategoryService(Session session) {
		this.meetingCategoryDao = new MeetingCategoryDaoImpl(session);
	}

	public void save(MeetingCategory meetingCategory) {
		this.meetingCategoryDao.save(meetingCategory);
	}

	public List<MeetingCategory> findAll() {
		return this.meetingCategoryDao.findAll();
	}

	public MeetingCategory findById(Long id) {
		return this.meetingCategoryDao.findById(id);
	}

	public void closeSession() {
		this.meetingCategoryDao.closeSession();
	}

}
