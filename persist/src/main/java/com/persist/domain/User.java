package com.persist.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String user_name;
	private String password;

	@OneToOne
	@JoinColumn(name = "type_user_id")
	private TypeUser typeUser;

	@OneToOne
	@JoinColumn(name = "consulting_room_id")
	private ConsultingRooms consultingRooms;

	@OneToOne
	@JoinColumn(name = "profile_id")
	private Profile profile;

	public User(String user_name, String password) {
		this.user_name = user_name;
		this.setPassword(password);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public TypeUser getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(TypeUser typeUser) {
		this.typeUser = typeUser;
	}

	public ConsultingRooms getConsultingRooms() {
		return consultingRooms;
	}

	public void setConsultingRooms(ConsultingRooms consultingRooms) {
		this.consultingRooms = consultingRooms;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -3102652220804526629L;

}
