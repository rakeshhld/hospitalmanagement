package com.hospital.hospitalmanagement.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.Data;

@Entity
@Data
public class Doctor {
	
	@Id
	@GeneratedValue
	@Column(name = "doctor_id")
	private int doctorId;
	private String firstName;
	private String lastname;
	private Date dob;
	private String specialization;
	private String education;
	private String gender;
	private int experience;
	/*@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
    Date createdAt;
    @LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
    Date modifiedAt;*/
}
