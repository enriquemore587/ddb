package com.persist.test;

import java.util.List;

import org.hibernate.Session;

import com.persist.domain.TypeUser;
import com.persist.service.TypeUserService;
import com.persist.util.HibernateUtil;

/**
 * @author Jose Enrique Vergara
 *
 */
public class TypeUserTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		TypeUserService service = new TypeUserService(session);

//		TypeUser typeUser = new TypeUser("MOBILE");
//		service.save(typeUser);
//		System.out.println(typeUser);

		List<TypeUser> list = service.findAll();
		System.out.println(list.size());
		System.out.println(list.toString());

		 TypeUser typeUser = service.findById(13l);
		 System.out.println(typeUser);

		service.closeSession();
		System.exit(0);

	}
}
