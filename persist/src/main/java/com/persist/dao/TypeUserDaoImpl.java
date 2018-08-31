package com.persist.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.persist.domain.TypeUser;

/**
 * @author Jose Enrique Vergara
 *
 */
public class TypeUserDaoImpl implements TypeUserDao {
	public static Logger LOG = Logger.getLogger(TypeUserDaoImpl.class.getName());
	private Session session;

	public TypeUserDaoImpl(Session session) {
		this.session = session;
	}

	public void save(TypeUser typeUser) {
		Transaction tx = null;
		try {
			tx = this.session.beginTransaction();

			this.session.save(typeUser);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

	}

	public List<TypeUser> findAll() {
		Transaction tx = null;
		List<TypeUser> typeUsers = null;
		try {
			tx = this.session.beginTransaction();
			CriteriaBuilder builder = this.session.getCriteriaBuilder();
			CriteriaQuery<TypeUser> criteria = builder.createQuery(TypeUser.class);

			Root<TypeUser> root = criteria.from(TypeUser.class);
			criteria.select(root);

			typeUsers = this.session.createQuery(criteria).getResultList();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				typeUsers = null;
			}
			e.printStackTrace();
		}
		return typeUsers;
	}

	public TypeUser findById(Long id) {
		Transaction tx = null;
		TypeUser typeUser = null;
		try {
			tx = this.session.beginTransaction();

			CriteriaBuilder builder = this.session.getCriteriaBuilder();
			CriteriaQuery<TypeUser> criteria = builder.createQuery(TypeUser.class);

			Root<TypeUser> root = criteria.from(TypeUser.class);
			criteria.select(root).where(builder.equal(root.get("id"), id));

			typeUser = this.session.createQuery(criteria).getSingleResult();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				typeUser = null;
			}
			e.printStackTrace();
		}
		return typeUser;
	}

	public void closeSession() {
		this.session.close();
	}

}
