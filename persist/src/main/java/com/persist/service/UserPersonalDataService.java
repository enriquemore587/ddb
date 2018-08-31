package com.persist.service;

import java.util.List;

import org.hibernate.Session;

import com.persist.dao.UserPersonalDataDao;
import com.persist.dao.UserPersonalDataDaoImpl;

/**
 * @author Jose Enrique Vergara
 *
 */
public class UserPersonalDataService implements UserPersonalDataDao {
	private UserPersonalDataDao userPersonalDataDao;

	public UserPersonalDataService(Session session) {
		this.userPersonalDataDao = new UserPersonalDataDaoImpl(session);
	}

	public void save(com.persist.domain.UserPersonalData userPersonalData) {
		this.userPersonalDataDao.save(userPersonalData);
	}

	public List<com.persist.domain.UserPersonalData> findAll() {
		return this.userPersonalDataDao.findAll();
	}

	public com.persist.domain.UserPersonalData findById(Long id) {
		return this.userPersonalDataDao.findById(id);
	}

	public void closeSession() {
		this.userPersonalDataDao.closeSession();
	}

}
