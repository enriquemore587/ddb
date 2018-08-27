package com.persist.test;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.persist.domain.ConsultingRooms;
import com.persist.domain.Profile;
import com.persist.domain.TypeUser;
import com.persist.domain.User;
import com.persist.domain.UserAddress;
import com.persist.util.HibernateUtil;

public class Test {
	public static Logger LOG = Logger.getLogger(Test.class.getName());

	public static void main(String[] args) {
		Session session = HibernateUtil.buildSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Profile profile = new Profile("MOBILE", 1);
			session.save(profile);
			TypeUser typeUser = new TypeUser("DOCTOR");
			session.save(typeUser);
			ConsultingRooms consultingRooms = new ConsultingRooms(13, "CONSULTORIO 1");
			session.save(consultingRooms);
			User user = new User("jose.asdra@mail.mail", "1234");

			user.setProfile(profile);
			user.setTypeUser(typeUser);
			user.setConsultingRooms(consultingRooms);
			session.save(user);
			UserAddress userAddress = new UserAddress(user.getId(), "55100", 1, 2, "colonia", "street", "num_ext",
					"num_int");
			user.setUserAddress(userAddress);
			session.save(user);

////			Consulta 
//			
//			CriteriaBuilder builder = session.getCriteriaBuilder();
//			CriteriaQuery<User> criteria = builder.createQuery(User.class);
//			
//			Root<User> root = criteria.from(User.class);
//			
//			criteria.select(root);
//						
//			List<User> userList = session.createQuery(criteria).getResultList();
//			
//			LOG.info(userList.toString());

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
