package com.persist.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "profiles")
public class Profile implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private int type;

	@OneToOne(mappedBy = "profile")
	private User user;

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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public Profile() {
		// TODO Auto-generated constructor stub
	}

	public Profile(String description, int type) {
		this.description = description;
		this.type = type;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5384254073162498739L;

}