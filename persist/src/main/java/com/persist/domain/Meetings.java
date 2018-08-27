package com.persist.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "meetings")
public class Meetings implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date date_meeting;

	@Temporal(TemporalType.TIME)
	private Date start_meeting;

	@Temporal(TemporalType.TIME)
	private Date end_meeting;

	private String is_important;

	private Float cost;

	private String meeting_done;

	private String paid;
	
	private Float debt;

	@OneToOne
	@JoinColumn(name = "doctor_id")
	private User doctor;

	@OneToOne
	@JoinColumn(name = "patient_id")
	private User patient;

	@OneToOne
	@JoinColumn(name = "type_meetings_id")
	private TypeMeetings typeMeetings;

	@OneToOne
	@JoinColumn(name = "meeting_category_id")
	MeetingCategory meetingCategory;

	@OneToMany(mappedBy="meetings")
	private List<Payments> paymentsList;

	public List<Payments> getPaymentsList() {
		return paymentsList;
	}

	public void setPaymentsList(List<Payments> paymentsList) {
		this.paymentsList = paymentsList;
	}

	public Meetings() {
		// TODO Auto-generated constructor stub
		this.paymentsList = new ArrayList<Payments>();
	}

	public Meetings(Date date_meeting, Date start_meeting, Date end_meeting, String is_important, Float cost,
			String meeting_done, String paid) {

		this.date_meeting = date_meeting;
		this.start_meeting = start_meeting;
		this.end_meeting = end_meeting;
		this.is_important = is_important;
		this.cost = cost;
		this.meeting_done = meeting_done;
		this.paid = paid;
		this.paymentsList = new ArrayList<Payments>();

	}

	public MeetingCategory getMeetingCategory() {
		return meetingCategory;
	}

	public void setMeetingCategory(MeetingCategory meetingCategory) {
		this.meetingCategory = meetingCategory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate_meeting() {
		return date_meeting;
	}

	public void setDate_meeting(Date date_meeting) {
		this.date_meeting = date_meeting;
	}

	public Date getStart_meeting() {
		return start_meeting;
	}

	public void setStart_meeting(Date start_meeting) {
		this.start_meeting = start_meeting;
	}

	public Date getEnd_meeting() {
		return end_meeting;
	}

	public void setEnd_meeting(Date end_meeting) {
		this.end_meeting = end_meeting;
	}

	public String getIs_important() {
		return is_important;
	}

	public void setIs_important(String is_important) {
		this.is_important = is_important;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public String getMeeting_done() {
		return meeting_done;
	}

	public void setMeeting_done(String meeting_done) {
		this.meeting_done = meeting_done;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public User getPatient() {
		return patient;
	}

	public void setPatient(User patient) {
		this.patient = patient;
	}

	public TypeMeetings getTypeMeetings() {
		return typeMeetings;
	}

	public void setTypeMeetings(TypeMeetings typeMeetings) {
		this.typeMeetings = typeMeetings;
	}

	public Float getDebt() {
		return debt;
	}

	public void setDebt(Float debt) {
		this.debt = debt;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4454606574395777435L;

}
