package com.persist.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_address")
public class UserAddress implements Serializable {
	
	@Id
	@Column(name="id")
	private Long id;
	
	private String cp;
	private Integer state;
	private Integer municipality;
	private String colony;
	private String street;
	private String num_ext;
	private String num_int;
	
	public UserAddress() {
		// TODO Auto-generated constructor stub
	}
	



	public UserAddress(Long id, String cp, Integer state, Integer municipality, String colony, String street,
			String num_ext, String num_int) {
		this.id = id;
		this.cp = cp;
		this.state = state;
		this.municipality = municipality;
		this.colony = colony;
		this.street = street;
		this.num_ext = num_ext;
		this.num_int = num_int;
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 6704650682304532027L;

}
