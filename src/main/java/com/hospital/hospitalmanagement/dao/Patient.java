package com.hospital.hospitalmanagement.dao;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
@Data
public class Patient {
	@Id
	@GeneratedValue
	@Column(name="patient_id")
	private int patientId;
	private String firstName;
	private String lastName;
	private String gender;
	private Date dob;
	private String phoneNumber;
	@Embedded
	private Address address;
	@CreatedDate
    Date createdAt;
    
    @LastModifiedDate
    Date modifiedAt;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id")
	private Doctor familyDoctor;

}
