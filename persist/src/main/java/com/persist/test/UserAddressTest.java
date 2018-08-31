package com.persist.test;

import java.util.List;

import org.hibernate.Session;

import com.persist.domain.User;
import com.persist.domain.UserAddress;
import com.persist.service.UserAddressService;
import com.persist.service.UserService;
import com.persist.util.HibernateUtil;

public class UserAddressTest {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionfactory().openSession();

		UserAddressService userAddressService = new UserAddressService(session);

//		UserAddress userAddress = new UserAddress("55100", 1, 2, "PATRIMONIO SOCIAL", "CUBA", "MZ 8 lT5", "1");
//
//		UserService userService = new UserService(session);
//
//		User user = userService.findById(11l);
//		
//		userAddress.setUser(user);
//		
//		System.out.println(userAddress);
//		System.out.println(userAddress.getUser());
//		
//		userAddressService.save(userAddress);

		UserAddress userAddress = userAddressService.findById(11l);
		System.out.println(userAddress);
		System.out.println(userAddress.getUser());

		List<UserAddress> list = userAddressService.findAll();
		for (UserAddress userAddress2 : list) {
			System.out.println("ok" + userAddress2);
		}

		System.exit(0);

	}
}
