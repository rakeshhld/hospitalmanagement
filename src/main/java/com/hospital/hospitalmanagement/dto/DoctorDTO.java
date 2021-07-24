package com.hospital.hospitalmanagement.dto;

import java.text.ParseException;
import java.util.Date;

import com.hospital.hospitalmanagement.dao.Doctor;
import com.hospital.hospitalmanagement.util.DateUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class DoctorDTO {
	private String firstName;
	private String lastname;
	private String dob;
	private String specialization;
	private String education;
	private String gender;
	private int experience;
	
	public Doctor getDoctorByDTO(){
		Doctor doc = new Doctor();
		doc.setFirstName(this.firstName);
		doc.setLastname(this.lastname);
		Date dateOfBirth = new Date();
		try{
			DateUtil.parseToDate(this.dob);
		}catch(ParseException pxe){
			pxe.printStackTrace();
		}
		doc.setGender("male");
		doc.setDob(dateOfBirth);
		doc.setSpecialization(this.specialization);
		doc.setEducation(this.education);
		doc.setEducation(this.education);
		doc.setExperience(this.experience);
		return doc;
	}
}
