package com.persist.service;

import java.util.List;

import org.hibernate.Session;

import com.persist.dao.ConsultingRoomsDao;
import com.persist.dao.ConsultingRoomsDaoImpl;
import com.persist.domain.ConsultingRooms;

/**
 * @author Jose Enrique Vergara
 *
 */
public class ConsultingRoomsService implements ConsultingRoomsDao {

	private ConsultingRoomsDao consultingRoomsDao;

	public ConsultingRoomsService(Session session) {
		this.consultingRoomsDao = new ConsultingRoomsDaoImpl(session);
	}

	public void save(ConsultingRooms consultingRooms) {
		this.consultingRoomsDao.save(consultingRooms);
	}

	public List<ConsultingRooms> findAll() {
		return this.consultingRoomsDao.findAll();
	}

	public ConsultingRooms findById(Long id) {
		return this.consultingRoomsDao.findById(id);
	}

	public void closeSession() {
		this.consultingRoomsDao.closeSession();
	}

}
