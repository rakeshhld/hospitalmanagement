package com.hospital.hospitalmanagement.service;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospitalmanagement.dao.Address;
import com.hospital.hospitalmanagement.dao.Login;
import com.hospital.hospitalmanagement.dao.Patient;
import com.hospital.hospitalmanagement.model.RegisterBean;
import com.hospital.hospitalmanagement.repo.RegistrationRepo;

@Service
@Transactional
public class PatientRegistrationService {
	@Autowired RegistrationRepo registerRepo;
	
	@Autowired PatientService ps;
	public boolean Register(RegisterBean registerBean) {
		Patient patient = new Patient();
		Address add = new Address();
		add.setHouseNo(101);
		add.setStreet("Shirala");
		add.setArea("Shirala");
		add.setCity("Shirala");
		add.setDistrict("Shirala");
		add.setTaluk("Shirala");
		add.setPinCode(411057);
		patient.setAddress(add);
		patient.setFirstName(registerBean.getFirstName());
		patient.setDob(new Date());
		patient.setLastName(registerBean.getLastName());
		patient.setGender("male");
		patient.setPhoneNumber(String.valueOf(registerBean.getMobileNo()));
		
		Login newloggginObj = new Login();
		Optional<Login> optionalLogin = registerRepo.findByEmail(registerBean.getEmail());
		if(optionalLogin.isPresent() ){
			return false;
		}
		newloggginObj.setEmail(registerBean.getEmail());
		newloggginObj.setPassword(registerBean.getPassword());
		registerRepo.save(newloggginObj);
		ps.addPatient(patient);
		return true;
	}

}
