package com.persist.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "type_meetings")
public class TypeMeetings implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@OneToOne(mappedBy = "typeMeetings")
	Meetings meetings;

	
	public TypeMeetings() {
		// TODO Auto-generated constructor stub
	}
	
	public TypeMeetings(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	private static final long serialVersionUID = 723316277207410750L;

}
