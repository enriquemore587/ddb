package com.persist.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Jose Enrique Vergara
 *
 */
@Entity
@Table(name = "type_meetings")
public class TypeMeetings implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@OneToMany(mappedBy = "typeMeetings")
	private List<Meetings> meetingsList;

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

	public List<Meetings> getMeetingsList() {
		return meetingsList;
	}

	public void setMeetingsList(List<Meetings> meetingsList) {
		this.meetingsList = meetingsList;
	}

	@Override
	public String toString() {
		return "TypeMeetings [id=" + id + ", description=" + description + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 723316277207410750L;

}
