package com.persist.test;

import java.util.List;

import org.hibernate.Session;

import com.persist.domain.CivilStatus;
import com.persist.service.CivilStatusService;
import com.persist.util.HibernateUtil;

/**
 * @author Jose Enrique Vergara
 *
 */
public class CivilStatusTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionfactory().openSession();

		CivilStatusService civilStatusService = new CivilStatusService(session);

//		SAVE

//		CivilStatus civilStatus = new CivilStatus("CASADO (A)");
//		civilStatusService.save(civilStatus);
//		System.out.println(civilStatus.toString());

//		SELECT * FROM 

		List<CivilStatus> list = civilStatusService.findAll();
		System.out.println(list.size());
		System.out.println(list.toString());

		CivilStatus civilStatus = civilStatusService.findById(1l);
		System.out.println(civilStatus.toString());

//		SELECT WHERE ID = ?
		civilStatus = civilStatusService.findById(2l);
		System.out.println(civilStatus.toString());

		civilStatusService.closeSession();
		System.exit(0);
	}
}
