package com.persist.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.persist.domain.UserAddress;

public class UserAddressDaoImpl implements UserAddressDao {
	private Session session;

	public UserAddressDaoImpl(Session session) {
		this.session = session;
	}

	public void save(UserAddress userAddress) {
		Transaction tx = null;
		try {
			tx = this.session.beginTransaction();
			this.session.save(userAddress);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<UserAddress> findAll() {
		Transaction tx = null;
		List<UserAddress> list = null;
		try {
			tx = this.session.beginTransaction();
			CriteriaBuilder builder = this.session.getCriteriaBuilder();
			CriteriaQuery<UserAddress> criteria = builder.createQuery(UserAddress.class);

			Root<UserAddress> root = criteria.from(UserAddress.class);

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

	public UserAddress findById(Long id) {
		Transaction tx = null;
		UserAddress userAddress = null;
		try {
			tx = this.session.beginTransaction();
			// Fábrica para las piezas individuales de la criteria
			CriteriaBuilder builder = this.session.getCriteriaBuilder();
			CriteriaQuery<UserAddress> criteria = builder.createQuery(UserAddress.class);

			// Define el tipo de entidadque retorna la consulta
			Root<UserAddress> root = criteria.from(UserAddress.class);

			criteria.where(builder.equal(root.get("id"), id));

			userAddress = this.session.createQuery(criteria).getSingleResult();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				userAddress = null;
			}
		}
		return userAddress;
	}

	public void closeSession() {
		this.session.close();
	}

}
