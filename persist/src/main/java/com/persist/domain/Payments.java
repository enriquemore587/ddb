package com.persist.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "payments")
public class Payments implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Float payment;

	@Temporal(TemporalType.TIMESTAMP)
	private Date payment_moment;

	@Temporal(TemporalType.DATE)
	private Date next_date_payment;

	@ManyToOne
	@JoinColumn(name = "meeting_id")
	private Meetings meetings;

	public Payments(Float payment, Date payment_moment, Date next_date_payment) {
		super();
		this.payment = payment;
		this.payment_moment = payment_moment;
		this.next_date_payment = next_date_payment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getPayment() {
		return payment;
	}

	public void setPayment(Float payment) {
		this.payment = payment;
	}

	public Date getPayment_moment() {
		return payment_moment;
	}

	public void setPayment_moment(Date payment_moment) {
		this.payment_moment = payment_moment;
	}

	public Date getNext_date_payment() {
		return next_date_payment;
	}

	public void setNext_date_payment(Date next_date_payment) {
		this.next_date_payment = next_date_payment;
	}

	public Meetings getMeetings() {
		return meetings;
	}

	public void setMeetings(Meetings meetings) {
		this.meetings = meetings;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7861078581225823844L;

}
