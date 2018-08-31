package com.persist.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.persist.domain.UserPersonalData;

/**
 * @author Jose Enrique Vergara
 *
 */
public class UserPersonalDataDaoImpl implements UserPersonalDataDao {
	public static Logger LOG = Logger.getLogger(UserPersonalDataDaoImpl.class.getName());
	private Session session;

	public UserPersonalDataDaoImpl(Session session) {
		this.session = session;
	}

	public void save(UserPersonalData userPersonalData) {
		Transaction tx = null;
		try {
			tx = this.session.beginTransaction();
			this.session.save(userPersonalData);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<UserPersonalData> findAll() {
		Transaction tx = null;
		List<UserPersonalData> list = null;
		try {
			tx = this.session.beginTransaction();
			CriteriaBuilder builder = this.session.getCriteriaBuilder();
			CriteriaQuery<UserPersonalData> criteria = builder.createQuery(UserPersonalData.class);

			Root<UserPersonalData> root = criteria.from(UserPersonalData.class);

			criteria.select(root);

			list = this.session.createQuery(criteria).getResultList();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				list = null;
			}
			e.printStackTrace();
		}
		return list;
	}

	public UserPersonalData findById(Long id) {
		Transaction tx = null;
		UserPersonalData userPersonalData = null;
		try {
			tx = this.session.beginTransaction();
			// Fábrica para las piezas individuales de la criteria
			CriteriaBuilder builder = this.session.getCriteriaBuilder();
			CriteriaQuery<UserPersonalData> criteria = builder.createQuery(UserPersonalData.class);

			// Define el tipo de entidadque retorna la consulta
			Root<UserPersonalData> root = criteria.from(UserPersonalData.class);

			criteria.where(builder.equal(root.get("id"), id));

			userPersonalData = this.session.createQuery(criteria).getSingleResult();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				userPersonalData = null;
			}
		}
		return userPersonalData;
	}

	public void closeSession() {
		this.session.close();
	}

}
