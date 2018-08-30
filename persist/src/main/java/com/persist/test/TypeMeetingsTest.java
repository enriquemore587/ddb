package com.persist.test;

import java.util.List;

import org.hibernate.Session;

import com.persist.domain.TypeMeetings;
import com.persist.service.TypeMeetingsService;
import com.persist.util.HibernateUtil;

public class TypeMeetingsTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionfactory().openSession();

		TypeMeetingsService typeMeetingsService = new TypeMeetingsService(session);

//		SAVE

		TypeMeetings typeMeetings = new TypeMeetings("RAPIDA");
		typeMeetingsService.save(typeMeetings);
		System.out.println(typeMeetings.toString());

//		SELECT * FROM 

		List<TypeMeetings> list = typeMeetingsService.findAll();
		System.out.println(list.size());
		System.out.println(list.toString());

		typeMeetings = typeMeetingsService.findById(1l);
		System.out.println(typeMeetings.toString());

//		SELECT WHERE ID = ?
		typeMeetings = typeMeetingsService.findById(2l);
		System.out.println(typeMeetings.toString());

		typeMeetingsService.closeSession();
		System.exit(0);
	}
}
