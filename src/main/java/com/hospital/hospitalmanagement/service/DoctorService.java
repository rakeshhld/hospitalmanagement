package com.hospital.hospitalmanagement.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospitalmanagement.dao.Doctor;
import com.hospital.hospitalmanagement.dto.DoctorDTO;
import com.hospital.hospitalmanagement.repo.DoctorRepository;

@Service
public class DoctorService {
	@Autowired DoctorRepository docRepo;

	public List<Doctor> getAllDoctors() {
		return docRepo.findAll();
	}

	public Doctor getDoctorByID(int patientId) {
		Optional<Doctor> optionalDoc = docRepo.findById(patientId);
		if(optionalDoc.isPresent()){
			return optionalDoc.get();
		}
		return null;
	}

	public Doctor addDoctor(DoctorDTO docDTO) {
		Doctor doctor = docDTO.getDoctorByDTO();
		return docRepo.save(doctor);
	}
	
	
	public Doctor updateDoctor(DoctorDTO docDTO) {
		Optional<Doctor> optionalDoc = docRepo.findById(docDTO.getDoctorId());
		if(optionalDoc.isPresent()){
			 Doctor doc = optionalDoc.get();
			 doc.setExperience(docDTO.getExperience());
			 return docRepo.save(doc);
		}
		return null;
	}
	public List<Doctor> getAllDoctorsBySpecialization(String specialization) {
		return docRepo.findAllBySpecialization(specialization);
	}
	
	public String deleteDoctorById(int id){
		docRepo.deleteById(id);
		return "SUCCESS";
	}
	
	@PostConstruct
	public void addDoctor(){
		DoctorDTO dto = new DoctorDTO(1,"Dr, Rahul", "Batras", "26-04-1994", "general physician", "M.D", "M", 4);
		addDoctor(dto);
	}

}
