package com.hospital.hospitalmanagement.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.hospitalmanagement.dao.Appointment;
import com.hospital.hospitalmanagement.dao.Doctor;
import com.hospital.hospitalmanagement.dao.Patient;
import com.hospital.hospitalmanagement.model.AppointmentModel;
import com.hospital.hospitalmanagement.repo.AppointmentRepository;
import com.hospital.hospitalmanagement.repo.DoctorRepository;
import com.hospital.hospitalmanagement.repo.PatientRepository;
import com.hospital.hospitalmanagement.util.DateUtil;

@Service
public class AppointmentService {
	@Autowired private DoctorRepository docRepo;
	@Autowired private PatientRepository patientRepo;
	@Autowired private AppointmentRepository appointmentRepo;

	public String createAppointment(int doctorId, int patientId,  AppointmentModel am) {
		Optional<Patient> optionalPatient = patientRepo.findById(patientId);
		Patient patient = null;
		if(optionalPatient.isPresent()){
			patient = optionalPatient.get();
		}
		Optional<Doctor> optionalDoc = docRepo.findById(doctorId);
		Doctor doctor = null;
		if(optionalDoc.isPresent()){
			doctor = optionalDoc.get();
		}
		Date sDate = null;
		Date eDate = null;
		try{
			sDate = DateUtil.parseToDatetime(am.getAppointmentDate());
			eDate = DateUtil.parseToDatetime(am.getAppointmentEndDate());
		}catch(ParseException pse){
			
		}
		Appointment appointment = new Appointment();
		appointment.setAppointmentStartDate(sDate);
		appointment.setAppointmentEndDate(eDate);
		appointment.setDoctor(doctor);
		appointment.setPatient(patient);
		appointmentRepo.save(appointment);
		return "SUCCESS";
	}
	
	public List<Appointment> getAllAppointments(){
		return appointmentRepo.findAll();
	}

}
