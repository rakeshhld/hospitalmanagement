package com.hospital.hospitalmanagement.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Login {

	@Id
	@GeneratedValue
	private int loginId;
	private String email;
	private String password;
	private String role;

}
