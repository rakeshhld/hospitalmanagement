package com.hospital.hospitalmanagement.resource;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospitalmanagement.dao.Patient;
import com.hospital.hospitalmanagement.dto.PatientDTO;
import com.hospital.hospitalmanagement.service.PatientService;

@RestController
public class PatientResource {
	@Autowired PatientService patientService;

	@GetMapping("/patient")
	public List<Patient> getAllPatients(){
		return patientService.getAllPatients();
	}
	
	@GetMapping("/patient/{Id}")
	public @ResponseBody Patient getPatientById(@PathVariable("Id") String id ){
		int patientId = Integer.parseInt(id);
		return patientService.getPatientByID(patientId);
	}
	
	@PostMapping("/patient")
	public @ResponseBody Patient addPatient(PatientDTO patient){
		return patientService.addPatient(patient);
	}
}
