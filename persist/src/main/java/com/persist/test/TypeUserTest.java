package com.persist.test;

import java.util.List;

import org.hibernate.Session;

import com.persist.domain.TypeUser;
import com.persist.service.TypeUserService;
import com.persist.util.HibernateUtil;

public class TypeUserTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.buildSessionFactory().openSession();
		TypeUserService service = new TypeUserService(session);

//		TypeUser typeUser = new TypeUser("MOBILE");
//		service.save(typeUser);
//		System.out.println(typeUser);

//		List<TypeUser> list = service.findAll();
//		System.out.println(list.toString());

		TypeUser typeUser = service.findById(6l);
		System.out.println(typeUser);
		
		
		service.closeSession();

	}
}
