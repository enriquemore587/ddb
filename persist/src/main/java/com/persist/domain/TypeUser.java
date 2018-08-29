package com.persist.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "type_users")
public class TypeUser implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;

	@OneToOne(mappedBy = "typeUser")
	private User user;

	public TypeUser() {
		// TODO Auto-generated constructor stub
	}

	public TypeUser(String description) {
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

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

//	@Override
//	public String toString() {
//		return "TypeUser [id=" + id + ", description=" + description + "]";
//	}
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 892308747196988982L;

	@Override
	public String toString() {
		return "TypeUser [id=" + id + ", description=" + description + ""
				+ ", user=" + user 
				+ "]";
	}

}
