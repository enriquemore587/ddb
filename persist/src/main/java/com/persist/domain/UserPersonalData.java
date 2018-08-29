package com.persist.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_personal_data")
public class UserPersonalData implements Serializable {

	@Id
	private Long id;

	private String name;
	private String last_name;
	private String last_name2;
	private String phone_number;
	private String mobile_phone_number;
	private String gender;
	private Date birthdate;
	private String important_note;

	@OneToOne
	@JoinColumn(name = "civil_status_id")
	private CivilStatus civilStatus;

	public UserPersonalData() {
		// TODO Auto-generated constructor stub
	}

	public UserPersonalData(String name, String last_name, String last_name2, String phone_number,
			String mobile_phone_number, String gender, Date birthdate, String important_note) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.last_name2 = last_name2;
		this.phone_number = phone_number;
		this.mobile_phone_number = mobile_phone_number;
		this.gender = gender;
		this.birthdate = birthdate;
		this.important_note = important_note;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getLast_name2() {
		return last_name2;
	}

	public void setLast_name2(String last_name2) {
		this.last_name2 = last_name2;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getMobile_phone_number() {
		return mobile_phone_number;
	}

	public void setMobile_phone_number(String mobile_phone_number) {
		this.mobile_phone_number = mobile_phone_number;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getImportant_note() {
		return important_note;
	}

	public void setImportant_note(String important_note) {
		this.important_note = important_note;
	}

	public CivilStatus getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(CivilStatus civilStatus) {
		this.civilStatus = civilStatus;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2107092155209282016L;

}
