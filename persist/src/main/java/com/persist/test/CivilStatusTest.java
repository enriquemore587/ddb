package com.persist.test;

import java.util.List;

import org.hibernate.Session;

import com.persist.domain.CivilStatus;
import com.persist.service.CivilStatusService;
import com.persist.util.HibernateUtil;

public class CivilStatusTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.buildSessionFactory().openSession();

//		SAVE
		
//		CivilStatusService civilStatusService = new CivilStatusService(session);
//		CivilStatus civilStatus = new CivilStatus("CASADO (A)");
//		civilStatusService.save(civilStatus);
//		System.out.println(civilStatus.toString());

		
//		SELECT * FROM 
		
//		CivilStatusService civilStatusService = new CivilStatusService(session);
//		List<CivilStatus> list = civilStatusService.findAll();
//		System.out.println(list);
		
//		CivilStatus civilStatus = civilStatusService.findById(1l);
//		System.out.println(civilStatus.toString());

		
//		SELECT WHERE ID = ?
		CivilStatusService civilStatusService = new CivilStatusService(session);
		CivilStatus civilStatus = civilStatusService.findById(2l);
		System.out.println(civilStatus.toString());
		
		
		civilStatusService.closeSession();
	}
}
