package com.persist.test;

import org.hibernate.Session;

import com.persist.domain.ConsultingRooms;
import com.persist.service.ConsultingRoomsService;
import com.persist.util.HibernateUtil;

public class ConsultingRoomsTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.buildSessionFactory().openSession();
		ConsultingRoomsService consultingRoomsService = new ConsultingRoomsService(session);

//		ConsultingRooms consultingRooms = new ConsultingRooms(4, "HIDALGO");
//		consultingRoomsService.save(consultingRooms);
//		System.out.println(consultingRooms);

//		List<ConsultingRooms> consultingRoomsList = consultingRoomsService.findAll();
//		for (ConsultingRooms consultingRooms : consultingRoomsList) {
//			System.out.println(consultingRooms);
//		}

		ConsultingRooms consultingRooms = consultingRoomsService.findById(4l);
		System.out.println(consultingRooms);

		consultingRoomsService.closeSession();

	}
}
