package com.persist.test;

import java.util.List;

import org.hibernate.Session;

import com.persist.domain.Profile;
import com.persist.service.ProfileService;
import com.persist.util.HibernateUtil;

/**
 * @author Jose Enrique Vergara
 *
 */
public class ProfileTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionfactory().openSession();

		ProfileService profileService = new ProfileService(session);

//	SAVE

//	Profile profile = new Profile("MOBILES1", 1);
//	profileService.save(profile);
//	System.out.println(profile.toString());

//	SELECT * FROM 

		List<Profile> list = profileService.findAll();
		System.out.println(list.size());
		for (Profile profile : list) {
			System.out.println(profile);
		}

		Profile profile = profileService.findById(9l);
		System.out.println(profile.toString());

//	SELECT WHERE ID = ?
//		profile = profileService.findById(10l);
//		System.out.println(profile.toString());
//
//		profileService.closeSession();
		System.exit(0);
	}
}
