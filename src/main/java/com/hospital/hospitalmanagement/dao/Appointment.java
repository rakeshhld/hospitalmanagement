package com.hospital.hospitalmanagement.dao;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
public class Appointment {
	@Id
	@GeneratedValue
	@Column(name="appointment_id")
	private int appointmentId;
	private Date appointmentStartDate;
	private Date appointmentEndDate;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id")
	private Patient patient;
	/*@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "pres_id")
	private Prescription perscription;*/
	@CreatedDate
    Date createdAt;
    @LastModifiedDate
    Date modifiedAt;

}
