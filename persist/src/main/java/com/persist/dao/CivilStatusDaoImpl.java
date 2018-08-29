package com.persist.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.persist.domain.CivilStatus;

public class CivilStatusDaoImpl implements CivilStatusDao {
	public static Logger LOG = Logger.getLogger(CivilStatusDaoImpl.class.getName());
	private Session session;

	public CivilStatusDaoImpl(Session session) {
		this.session = session;
	}

	public void save(CivilStatus civilStatus) {
		Transaction tx = null;
		try {
			tx = this.session.beginTransaction();
			this.session.save(civilStatus);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<CivilStatus> findAll() {
		Transaction tx = null;
		List<CivilStatus> civilStatusList = null;
		try {
			tx = this.session.beginTransaction();
			CriteriaBuilder builder = this.session.getCriteriaBuilder();
			CriteriaQuery<CivilStatus> criteria = builder.createQuery(CivilStatus.class);

			Root<CivilStatus> root = criteria.from(CivilStatus.class);
			criteria.select(root);

			civilStatusList = this.session.createQuery(criteria).getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				civilStatusList = null;
			}
			e.printStackTrace();
		}
		return civilStatusList;
	}

	public CivilStatus findById(Long id) {
		Transaction tx = null;
		CivilStatus civilStatus = null;
		try {
			tx = this.session.beginTransaction();

			CriteriaBuilder builder = this.session.getCriteriaBuilder();
			CriteriaQuery<CivilStatus> criteria = builder.createQuery(CivilStatus.class);

			Root<CivilStatus> root = criteria.from(CivilStatus.class);

			criteria.select(root).where(builder.equal(root.get("id"), id));

			civilStatus = this.session.createQuery(criteria).getSingleResult();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return civilStatus;
	}

	public void closeSession() {
		this.session.close();
	}

}
