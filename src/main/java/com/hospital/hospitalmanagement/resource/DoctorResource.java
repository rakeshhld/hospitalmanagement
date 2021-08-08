package com.hospital.hospitalmanagement.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospitalmanagement.dao.Doctor;
import com.hospital.hospitalmanagement.dto.DoctorDTO;
import com.hospital.hospitalmanagement.service.DoctorService;

@RestController
public class DoctorResource {
	@Autowired DoctorService docService;
	
	@GetMapping("/doctor")
	public List<Doctor> getAllDoctors(){
		return docService.getAllDoctors();
	}
	
	@GetMapping("/doctor/{Id}")
	public @ResponseBody Doctor getDoctorById(@PathVariable("Id") String id ){
		int patientId = Integer.parseInt(id);
		return docService.getDoctorByID(patientId);
	}
	
	@PostMapping("/doctor")
	public @ResponseBody Doctor addPatient(@RequestBody DoctorDTO patient){
		return docService.addDoctor(patient);
	}
	
	@GetMapping("/doctor/specialization/{Id}")
	public @ResponseBody List<Doctor> getPatientBySpecialization(@PathVariable("Id") String specialization ) {
		return docService.getAllDoctorsBySpecialization(specialization);
	}
	
	
}
