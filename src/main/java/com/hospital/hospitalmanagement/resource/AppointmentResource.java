package com.hospital.hospitalmanagement.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.hospitalmanagement.dao.Appointment;
import com.hospital.hospitalmanagement.model.AppointmentModel;
import com.hospital.hospitalmanagement.service.AppointmentService;

import lombok.Data;

@RestController
public class AppointmentResource {
	@Autowired AppointmentService aps;
	
	@PostMapping("/appointment/patient/{pId}/doctor/{docId}")
	public Result setAppointment(@PathVariable("docId") String doctorIdParam,
			@PathVariable("pId") String patientIdParam, @RequestBody AppointmentModel am
			){
		int doctorId = Integer.parseInt(doctorIdParam);
		int patientId = Integer.parseInt(patientIdParam);
		Result res = new Result();
		res.setResult(aps.createAppointment(doctorId,patientId,am));
		return res;
	}
	@GetMapping("/appointment")
	public List<Appointment> getallappointments(){
		return aps.getAllAppointments();
	}

}
@Data
class Result {
	String result;
}
