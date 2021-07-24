package com.hospital.hospitalmanagement.dao;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
@Data
public class Prescription {
	
	@Id
	@GeneratedValue
	@Column(name="pres_id")
	private int prescriptionId;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "medicine_id")
	private  Set<Medicine> Medicines;
	
	private Date  prescriptionDate;
	private int courseDuration;
	private int status;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@CreatedDate
    Date createdAt;
    @LastModifiedDate
    Date modifiedAt;
}
