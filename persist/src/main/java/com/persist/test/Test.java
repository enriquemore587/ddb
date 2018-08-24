package com.persist.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.persist.domain.ConsultingRooms;
import com.persist.domain.Profile;
import com.persist.domain.TypeUser;
import com.persist.domain.User;
import com.persist.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.buildSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Profile profile = new Profile("MOBILE", 1);
			session.save(profile);
			TypeUser typeUser = new TypeUser("DOCTOR");
			session.save(typeUser);
			ConsultingRooms consultingRooms = new ConsultingRooms(2, "CONSULTORIO 1");
			session.save(consultingRooms);
			User user = new User("enrique.vergara@mail.mail", "1234");
			user.setProfile(profile);
			user.setTypeUser(typeUser);
			user.setConsultingRooms(consultingRooms);
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println(1);
	}
}
