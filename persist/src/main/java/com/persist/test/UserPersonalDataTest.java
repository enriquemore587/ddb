package com.persist.test;

import java.util.Date;

import org.hibernate.Session;

import com.persist.dao.UserDao;
import com.persist.dao.UserDaoImpl;
import com.persist.domain.User;
import com.persist.domain.UserPersonalData;
import com.persist.service.UserPersonalDataService;
import com.persist.util.HibernateUtil;

/**
 * @author Jose Enrique Vergara
 *
 */
public class UserPersonalDataTest {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionfactory().openSession();
		
		UserPersonalDataService userPersonalDataService = new UserPersonalDataService(session);
		UserPersonalData userPersonalData =new UserPersonalData("JOSE", "AMBRIZ", "VERGARA", "5522555566", "5522998888", "H", new Date(), "Y");
		
		UserDao userDao = new UserDaoImpl(session);
		User user = userDao.findById(11l);
		userPersonalData.setUser(user);
		
		
		
		userPersonalData = userPersonalDataService.findById(11l);
		System.out.println(userPersonalData);
		userPersonalDataService.save(userPersonalData);
		
		System.exit(0);
		
	}

}
