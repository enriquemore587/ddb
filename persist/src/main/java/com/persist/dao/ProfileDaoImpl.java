package com.persist.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.persist.domain.Profile;

public class ProfileDaoImpl implements ProfileDao {

	private Session session;
	public static Logger LOG = Logger.getLogger(ProfileDaoImpl.class.getName());

	public ProfileDaoImpl(Session session) {
		this.session = session;
	}

	public void save(Profile profile) {
		Transaction tx = null;
		try {
			tx = this.session.beginTransaction();
			this.session.save(profile);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Profile> findAll() {
		Transaction tx = null;
		List<Profile> civilStatusList = null;
		try {
			tx = this.session.beginTransaction();
			CriteriaBuilder builder = this.session.getCriteriaBuilder();
			CriteriaQuery<Profile> criteria = builder.createQuery(Profile.class);

			Root<Profile> root = criteria.from(Profile.class);
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

	public Profile findById(Long id) {
		Transaction tx = null;
		Profile profile = null;
		try {
			tx = this.session.beginTransaction();

			CriteriaBuilder builder = this.session.getCriteriaBuilder();
			CriteriaQuery<Profile> criteria = builder.createQuery(Profile.class);

			Root<Profile> root = criteria.from(Profile.class);

			criteria.select(root).where(builder.equal(root.get("id"), id));

			profile = this.session.createQuery(criteria).getSingleResult();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				profile = null;
			}
			e.printStackTrace();
		}
		return profile;
	}

	public void closeSession() {
		this.session.close();
	}

}
