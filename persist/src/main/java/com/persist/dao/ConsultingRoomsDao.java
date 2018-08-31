package com.persist.dao;

import java.util.List;

import com.persist.domain.ConsultingRooms;

/**
 * @author Jose Enrique Vergara
 *
 */
public interface ConsultingRoomsDao {

	public void save(ConsultingRooms consultingRooms);

	public List<ConsultingRooms> findAll();

	public ConsultingRooms findById(Long id);

	public void closeSession();

}
