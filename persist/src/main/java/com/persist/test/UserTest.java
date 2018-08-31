package com.persist.test;

import java.util.List;

import org.hibernate.Session;

import com.persist.domain.User;
import com.persist.service.UserService;
import com.persist.util.HibernateUtil;

public class UserTest {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionfactory().openSession();

//		User user = new User("enrique@enrique.com", "123");
//
//		TypeUserService typeUserService = new TypeUserService(session);
//		TypeUser typeUser = typeUserService.findById(6l);
//		user.setTypeUser(typeUser);
//
//		ProfileService profileService = new ProfileService(session);
//		Profile profile = profileService.findById(9l);
//		user.setProfile(profile);
//
//		ConsultingRoomsService consultingRoomsService = new ConsultingRoomsService(session);
//		ConsultingRooms consultingRooms = consultingRoomsService.findById(1l);
//		user.setConsultingRooms(consultingRooms);
//		
//		
//		UserService userService = new UserService(session);
//		userService.save(user);

		UserService userService = new UserService(session);
		User user = userService.findById(11l);

		System.out.println(user);
		System.out.println(user.getTypeUser());
		System.out.println(user.getProfile());
		System.out.println(user.getConsultingRooms());

		List<User> userList = userService.findAll();

		for (User user2 : userList) {
			System.out.println(user2);
		}

		System.exit(0);
	}
}
