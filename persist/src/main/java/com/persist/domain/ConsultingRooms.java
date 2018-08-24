package com.persist.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consulting_rooms")
public class ConsultingRooms implements Serializable {

	@Id
	private int id;
	private String description;

	@OneToOne(mappedBy = "consultingRooms")
	private User user;

	public ConsultingRooms(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7947136898976517112L;

}
