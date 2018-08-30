package com.persist.test;

import java.util.List;

import org.hibernate.Session;

import com.persist.domain.MeetingCategory;
import com.persist.service.MeetingCategoryService;
import com.persist.util.HibernateUtil;

public class MeetingCategoryTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		MeetingCategoryService meetingCategoryService = new MeetingCategoryService(session);

//		MeetingCategory meetingCategory = new MeetingCategory("33333");
//		meetingCategoryService.save(meetingCategory);
//		System.out.println(meetingCategory);

		List<MeetingCategory> list = meetingCategoryService.findAll();

		for (MeetingCategory meetingCategory2 : list) {
			System.out.println("lista" + meetingCategory2);
		}

		MeetingCategory 
		meetingCategory = meetingCategoryService.findById(1l);
		System.out.println(meetingCategory);

		meetingCategoryService.closeSession();
		System.exit(0);
	}
}
