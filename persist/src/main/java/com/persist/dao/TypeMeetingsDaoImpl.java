package com.persist.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.persist.domain.TypeMeetings;

public class TypeMeetingsDaoImpl implements TypeMeetingsDao {
	public static Logger LOG = Logger.getLogger(TypeMeetingsDaoImpl.class.getName());
	private Session session;

	public TypeMeetingsDaoImpl(Session session) {
		this.session = session;
	}

	public void save(TypeMeetings meetings) {
		Transaction tx = null;
		try {
			tx = this.session.beginTransaction();
			this.session.save(meetings);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<TypeMeetings> findAll() {
		Transaction tx = null;
		List<TypeMeetings> typeMeetingsList = null;
		try {
			tx = this.session.beginTransaction();
			CriteriaBuilder builder = this.session.getCriteriaBuilder();
			CriteriaQuery<TypeMeetings> criteria = builder.createQuery(TypeMeetings.class);

			Root<TypeMeetings> root = criteria.from(TypeMeetings.class);
			criteria.select(root);

			typeMeetingsList = this.session.createQuery(criteria).getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				typeMeetingsList = null;
			}
			e.printStackTrace();
		}
		return typeMeetingsList;
	}

	public TypeMeetings findById(Long id) {
		Transaction tx = null;
		TypeMeetings typeMeetings = null;
		try {
			tx = this.session.beginTransaction();

			CriteriaBuilder builder = this.session.getCriteriaBuilder();
			CriteriaQuery<TypeMeetings> criteria = builder.createQuery(TypeMeetings.class);

			Root<TypeMeetings> root = criteria.from(TypeMeetings.class);

			criteria.select(root).where(builder.equal(root.get("id"), id));

			typeMeetings = this.session.createQuery(criteria).getSingleResult();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				typeMeetings = null;
			}
			e.printStackTrace();
		}
		return typeMeetings;
	}

	public void closeSession() {
		this.session.close();
	}

}
