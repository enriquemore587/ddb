package com.persist.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.persist.domain.ConsultingRooms;

/**
 * @author Jose Enrique Vergara
 *
 */
public class ConsultingRoomsDaoImpl implements ConsultingRoomsDao {
	public static Logger LOG = Logger.getLogger(ConsultingRoomsDaoImpl.class.getName());
	private Session session;

	public ConsultingRoomsDaoImpl(Session session) {
		this.session = session;
	}

	public void save(ConsultingRooms consultingRooms) {
		Transaction tx = null;
		try {
			tx = this.session.beginTransaction();
			this.session.save(consultingRooms);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<ConsultingRooms> findAll() {
		Transaction tx = null;
		List<ConsultingRooms> list = null;
		try {
			tx = this.session.beginTransaction();
			CriteriaBuilder builder = this.session.getCriteriaBuilder();
			CriteriaQuery<ConsultingRooms> criteria = builder.createQuery(ConsultingRooms.class);

			Root<ConsultingRooms> root = criteria.from(ConsultingRooms.class);

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

	public ConsultingRooms findById(Long id) {
		Transaction tx = null;
		ConsultingRooms consultingRooms = null;
		try {
			tx = this.session.beginTransaction();

			CriteriaBuilder builder = this.session.getCriteriaBuilder();
			CriteriaQuery<ConsultingRooms> criteria = builder.createQuery(ConsultingRooms.class);

			Root<ConsultingRooms> root = criteria.from(ConsultingRooms.class);

			criteria.select(root).where(builder.equal(root.get("id"), id));

			consultingRooms = this.session.createQuery(criteria).getSingleResult();

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				consultingRooms = null;
			}
			e.printStackTrace();
		}
		return consultingRooms;
	}

	public void closeSession() {
		this.session.close();
	}

}
