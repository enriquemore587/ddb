package com.persist.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "user_address")
public class UserAddress implements Serializable {

	@Id
	@GeneratedValue(generator="gen")
	@Column(unique=true, nullable=false)
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(value="user", name = "property") )
	private Long id;

	private String cp;
	private Integer state;
	private Integer municipality;
	private String colony;
	private String street;
	private String num_ext;
	private String num_int;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private User user;

	public UserAddress() {
	}
	
	public UserAddress(String cp, Integer state, Integer municipality, String colony, String street,
			String num_ext, String num_int) {
		this.cp = cp;
		this.state = state;
		this.municipality = municipality;
		this.colony = colony;
		this.street = street;
		this.num_ext = num_ext;
		this.num_int = num_int;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getMunicipality() {
		return municipality;
	}

	public void setMunicipality(Integer municipality) {
		this.municipality = municipality;
	}

	public String getColony() {
		return colony;
	}

	public void setColony(String colony) {
		this.colony = colony;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNum_ext() {
		return num_ext;
	}

	public void setNum_ext(String num_ext) {
		this.num_ext = num_ext;
	}

	public String getNum_int() {
		return num_int;
	}

	public void setNum_int(String num_int) {
		this.num_int = num_int;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", cp=" + cp + ", state=" + state + ", municipality=" + municipality
				+ ", colony=" + colony + ", street=" + street + ", num_ext=" + num_ext + ", num_int=" + num_int + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6704650682304532027L;

}
