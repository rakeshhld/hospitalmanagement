package com.hospital.hospitalmanagement.dto;

import lombok.Data;

@Data
public class PatientDTO {
	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	private String phoneNumber;
	private int houseNo;
	private String street;
	private String area;
	private String city;
	private String district;
	private String taluk;
	private int pinCode;
	private int doctorId;
}
