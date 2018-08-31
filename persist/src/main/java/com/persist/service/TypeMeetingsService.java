package com.persist.service;

import java.util.List;

import org.hibernate.Session;

import com.persist.dao.TypeMeetingsDao;
import com.persist.dao.TypeMeetingsDaoImpl;
import com.persist.domain.TypeMeetings;

/**
 * @author Jose Enrique Vergara
 *
 */
public class TypeMeetingsService implements TypeMeetingsDao {
	private TypeMeetingsDao typeMeetingsDao;

	public TypeMeetingsService(Session session) {
		this.typeMeetingsDao = new TypeMeetingsDaoImpl(session);
	}

	public void save(TypeMeetings meetings) {
		this.typeMeetingsDao.save(meetings);
	}

	public List<TypeMeetings> findAll() {
		return this.typeMeetingsDao.findAll();
	}

	public TypeMeetings findById(Long id) {
		return this.typeMeetingsDao.findById(id);
	}

	public void closeSession() {
		this.typeMeetingsDao.closeSession();
	}

}
