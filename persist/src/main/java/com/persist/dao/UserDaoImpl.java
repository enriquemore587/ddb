package com.persist.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.persist.domain.User;

public class UserDaoImpl implements UserDao {
	private Session session;

	public UserDaoImpl(Session session) {
		this.session = session;
	}

	public void save(User user) {
		Transaction tx = null;
		try {
			tx = this.session.beginTransaction();
			this.session.save(user);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	public User findById(Long id) {
		Transaction tx = null;
		User user = null;
		try {
			tx = this.session.beginTransaction();
			// Fábrica para las piezas individuales de la criteria
			CriteriaBuilder builder = this.session.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);

			// Define el tipo de entidadque retorna la consulta
			Root<User> root = criteria.from(User.class);

			criteria.where(builder.equal(root.get("id"), id));

			user = this.session.createQuery(criteria).getSingleResult();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				user = null;
			}
		}
		return user;
	}

	public void closeSession() {
		this.session.close();
	}

}
