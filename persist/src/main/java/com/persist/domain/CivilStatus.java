package com.persist.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "civil_status")
public class CivilStatus implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;

	@OneToOne(mappedBy = "civilStatus")
	private UserPersonalData userPersonalData;

	public CivilStatus() {
		// TODO Auto-generated constructor stub
	}

	public CivilStatus(String description) {
		this.description = description;
	}

//	public UserPersonalData getUserPersonalData() {
//		return userPersonalData;
//	}
//
//	public void setUserPersonalData(UserPersonalData userPersonalData) {
//		this.userPersonalData = userPersonalData;
//	}

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

	
	
//	@Override
//	public String toString() {
//		return "CivilStatus [id=" + id + ", description=" + description + "]";
//	}

	@Override
	public String toString() {
		return "CivilStatus [id=" + id + ", description=" + description + ", "
//				+ "userPersonalData=" 
//				+ userPersonalData
				+ "]";
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1762833200359843578L;
}
