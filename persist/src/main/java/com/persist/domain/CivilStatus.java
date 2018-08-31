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
@Table(name = "civil_status")
public class CivilStatus implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;

	@OneToMany(mappedBy = "civilStatus")
	private List<UserPersonalData> userPersonalDataList;

	public CivilStatus() {
		// TODO Auto-generated constructor stub
	}

	public CivilStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<UserPersonalData> getUserPersonalDataList() {
		return userPersonalDataList;
	}

	public void setUserPersonalDataList(List<UserPersonalData> userPersonalDataList) {
		this.userPersonalDataList = userPersonalDataList;
	}

	@Override
	public String toString() {
		return "CivilStatus [id=" + id + ", description=" + description + "]";
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1762833200359843578L;
}
