package com.persist.service;

import java.util.List;

import org.hibernate.Session;

import com.persist.dao.TypeUserDao;
import com.persist.dao.TypeUserDaoImpl;
import com.persist.domain.TypeUser;

public class TypeUserService implements TypeUserDao {

	private TypeUserDao typeUserDao;

	public TypeUserService(Session session) {
		this.typeUserDao = new TypeUserDaoImpl(session);
	}

	public void save(TypeUser typeUser) {
		this.typeUserDao.save(typeUser);
	}

	public List<TypeUser> findAll() {
		return this.typeUserDao.findAll();
	}

	public TypeUser findById(Long id) {
		return this.typeUserDao.findById(id);
	}

	public void closeSession() {
		this.typeUserDao.closeSession();
	}

}
