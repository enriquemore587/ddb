package com.persist.service;

import java.util.List;

import org.hibernate.Session;

import com.persist.dao.ProfileDao;
import com.persist.dao.ProfileDaoImpl;
import com.persist.domain.Profile;

public class ProfileService implements ProfileDao {
	private ProfileDao profileDao;

	public ProfileService(Session session) {
		this.profileDao = new ProfileDaoImpl(session);
	}

	public void save(Profile profile) {
		this.profileDao.save(profile);
	}

	public List<Profile> findAll() {
		return this.profileDao.findAll();
	}

	public Profile findById(Long id) {
		return this.profileDao.findById(id);
	}

	public void closeSession() {
		this.profileDao.closeSession();
	}

}
