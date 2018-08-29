package com.persist.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.persist.domain.MeetingCategory;

public class MeetingCategoryDaoImpl implements MeetingCategoryDao {
	public static Logger LOG = Logger.getLogger(MeetingCategoryDaoImpl.class.getName());
	private Session session;

	public MeetingCategoryDaoImpl(Session session) {
		this.session = session;
	}

	public void save(MeetingCategory meetingCategory) {
		Transaction tx = null;
		try {
			tx = this.session.beginTransaction();
			this.session.save(meetingCategory);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<MeetingCategory> findAll() {
		Transaction tx = null;
		List<MeetingCategory> list = null;
		try {
			tx = this.session.beginTransaction();
			CriteriaBuilder builder = this.session.getCriteriaBuilder();
			CriteriaQuery<MeetingCategory> criteria = builder.createQuery(MeetingCategory.class);

			Root<MeetingCategory> root = criteria.from(MeetingCategory.class);

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

	public MeetingCategory findById(Long id) {
		Transaction tx = null;
		MeetingCategory meetingCategory = null;
		try {
			tx = this.session.beginTransaction();

			CriteriaBuilder builder = this.session.getCriteriaBuilder();
			CriteriaQuery<MeetingCategory> criteria = builder.createQuery(MeetingCategory.class);

			Root<MeetingCategory> root = criteria.from(MeetingCategory.class);

			criteria.select(root).where(builder.equal(root.get("id"), id));

			meetingCategory = this.session.createQuery(criteria).getSingleResult();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				meetingCategory = null;
			}
			e.printStackTrace();
		}
		return meetingCategory;
	}

	public void closeSession() {
		this.session.close();
	}

}
