package com.hospital.hospitalmanagement.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospitalmanagement.dao.Address;
import com.hospital.hospitalmanagement.dao.Doctor;
import com.hospital.hospitalmanagement.dao.Patient;
import com.hospital.hospitalmanagement.dto.PatientDTO;
import com.hospital.hospitalmanagement.repo.DoctorRepository;
import com.hospital.hospitalmanagement.repo.PatientRepository;
import com.hospital.hospitalmanagement.util.DateUtil;

@Service
public class PatientService {
	
	@Autowired PatientRepository patientRepo;
	
	@Autowired DoctorRepository doctorRepo;
	
	public List<Patient> getAllPatients() {
		return patientRepo.findAll();
	}

	public Patient addPatient(PatientDTO pdto) {
		Date dob = null;
		try {
			dob = DateUtil.parseToDate(pdto.getDob());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Address addressObj = new Address();
		addressObj.setHouseNo(pdto.getHouseNo());
		addressObj.setArea(pdto.getArea());
		addressObj.setCity(pdto.getCity());
		addressObj.setDistrict(pdto.getDistrict());
		addressObj.setTaluk(pdto.getTaluk());
		addressObj.setPinCode(pdto.getPinCode());
		Patient patient = new Patient();
		patient.setAddress(addressObj);
		patient.setFirstName(pdto.getFirstName());
		patient.setDob(dob);
		patient.setLastName(pdto.getLastName());
		patient.setGender(pdto.getGender());
		patient.setPhoneNumber(pdto.getPhoneNumber());
		Optional<Doctor> optionalObj = doctorRepo.findById(pdto.getDoctorId());
		if(optionalObj.isPresent()){
			patient.setFamilyDoctor(optionalObj.get());
		}
		
		return patientRepo.save(patient);
	}
	public Patient addPatient(Patient patient) {
		return patientRepo.save(patient);
	}
	@PostConstruct
	public void addPatient(){
		PatientDTO pdto = new PatientDTO();
		pdto.setFirstName("Rakesh");
		pdto.setLastName("Haladi");
		pdto.setGender("Male");
		pdto.setDob("26-04-1994");
		pdto.setPhoneNumber("8792949863");
		pdto.setHouseNo(101);
		pdto.setStreet("Bhujbal wasti");
		pdto.setArea("Wakad");
		pdto.setCity("Pune");
		pdto.setDistrict("Pune");
		pdto.setTaluk("Pune");
		pdto.setPinCode(411057);
		addPatient(pdto);
	}

	public Patient getPatientByID(int id) {
		Optional<Patient> patientOps = patientRepo.findById(id);
		if(patientOps.isPresent()){
			return patientOps.get();
		}
		return null;
	}

}
