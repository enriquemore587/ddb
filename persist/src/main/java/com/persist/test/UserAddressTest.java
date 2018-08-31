package com.persist.test;

import org.hibernate.Session;

import com.persist.util.HibernateUtil;

public class UserAddressTest {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionfactory().openSession();
		
	}
}
