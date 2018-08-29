package com.persist.service;

import java.util.List;

import org.hibernate.Session;

import com.persist.dao.CivilStatusDao;
import com.persist.dao.CivilStatusDaoImpl;
import com.persist.domain.CivilStatus;

public class CivilStatusService implements CivilStatusDao {

	private CivilStatusDao civilStatusDao;

	public CivilStatusService(Session session) {
		this.civilStatusDao = new CivilStatusDaoImpl(session);
	}

	public void save(CivilStatus civilStatus) {
		this.civilStatusDao.save(civilStatus);
	}

	public List<CivilStatus> findAll() {
		return this.civilStatusDao.findAll();
	}

	public CivilStatus findById(Long id) {
		return this.civilStatusDao.findById(id);
	}

	public void closeSession() {
		this.civilStatusDao.closeSession();		
	}

}
